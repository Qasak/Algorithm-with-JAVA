package leetcode.SpringRecruit.并发.线程交替执行;

import java.util.function.IntConsumer;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/8 16:45
 */
public class Q1116_打印零与奇偶数_synchronized {
    class ZeroEvenOdd {
        private int n;
        private int i = 0;
        public ZeroEvenOdd(int n) {
            this.n = n;
        }
        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            synchronized(this) {
                while(i < 2 * n) {
                    while(i % 2 != 0) {
                        wait();
                    }
                    if(i >= 2 * n) {
                        // System.out.println("break ze " + i);
                        i++;
                        notifyAll();
                        break;
                    }
                    // System.out.println("0 " + i);
                    printNumber.accept(0);
                    i++;
                    notifyAll();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            synchronized(this) {
                while(i < 2 * n) {
                    // 以下代码需要抢到锁才能执行
                    // 即使抢到了锁，不满足当前i / 2 是奇数的条件，也要等待
                    while(i % 2 == 0 || (i / 2 % 2) != 1) {
                        wait();
                    }
                    if(i >= 2 * n) {
                        // System.out.println("break ev " + i);
                        notifyAll();
                        break;
                    }
                    // System.out.println("ev " + i);
                    printNumber.accept((i + 1) / 2);
                    i++;
                    notifyAll();
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            while(i < 2 * n) {
                synchronized(this) {
                    while(i % 2 == 0 || (i / 2 % 2) != 0) {
                        wait();
                    }
                    if(i >= 2 * n) {
                        // System.out.println("break od " + i);
                        notifyAll();
                        break;
                    }
                    // System.out.println("od " + i);
                    printNumber.accept((i + 1) / 2);
                    i++;
                    notifyAll();
                }
            }
        }
    }
}
