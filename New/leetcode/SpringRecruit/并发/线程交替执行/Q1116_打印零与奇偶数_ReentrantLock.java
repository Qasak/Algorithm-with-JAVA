package leetcode.SpringRecruit.并发.线程交替执行;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/8 0:20
 */
public class Q1116_打印零与奇偶数_ReentrantLock {
    class ZeroEvenOdd {
        ReentrantLock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();



        private int n;
        private volatile boolean flag = true;
        private volatile int idx = 0;
        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for(; idx < n; ) {
                lock.lock();
                try {
                    while(!flag) {
                        c1.await();
                    }
                    if((idx & 1) == 0) {
                        printNumber.accept(0);
                        idx++;
                        c2.signal();
                    } else {
                        printNumber.accept(0);
                        idx++;
                        c3.signal();
                    }
                    flag = false;
                } finally {
                    lock.unlock();
                }

            }
        }
        public void odd(IntConsumer printNumber) throws InterruptedException {
            for(int i = 1; i <= n; i += 2) {
                lock.lock();
                try {
                    while(flag || (idx & 1) == 0) {
                        c2.await();
                    }

                    printNumber.accept(i);
                    flag = true;
                    c1.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
        public void even(IntConsumer printNumber) throws InterruptedException {
            for(int i = 2; i <= n; i += 2) {
                lock.lock();
                try {
                    // 注意
                    while(flag || (idx & 1) == 1) {
                        c3.await();
                    }
                    printNumber.accept(i);
                    flag = true;
                    c1.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
