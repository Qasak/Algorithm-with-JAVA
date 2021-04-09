package leetcode.SpringRecruit.并发.线程交替执行;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/7 17:30
 */
public class Q1116_打印零与奇偶数_Semaphore {
    public static void main(String[] args) {
        AtomicInteger a = new AtomicInteger(0);
    }
}
class ZeroEvenOdd {
    Semaphore z = new Semaphore(1);
    Semaphore o = new Semaphore(0);
    Semaphore e = new Semaphore(0);


    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i = 0; i < n; i++) {
            z.acquire();
            printNumber.accept(0);
            if((i & 1) == 0) {
                o.release();
            } else {
                e.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 2; i <= n; i += 2) {
            e.acquire();
            printNumber.accept(i);
            z.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= n; i += 2) {
            o.acquire();
            printNumber.accept(i);
            z.release();
        }
    }
}
