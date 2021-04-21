package leetcode.SpringRecruit.并发.线程交替执行;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/7 15:51
 */
public class Q1114_按序打印_AtomicInteger {
    AtomicInteger a = new AtomicInteger(0);
    AtomicInteger b = new AtomicInteger(0);
    public Q1114_按序打印_AtomicInteger() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        a.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(a.get() != 1) {

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        b.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(b.get() != 1) {

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
