package leetcode.SpringRecruit.并发.线程交替执行;

import java.util.Objects;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/7 16:24
 */
public class Q1114_按序打印_synchronized {
    public static void main(String[] args) throws InterruptedException {
        Foo1 f = new Foo1();
        f.second(new Work(2));
        f.first(new Work(1));
        f.third(new Work(3));
    }
}
class Foo1 {
    private int a = 0;
    private Object lock = new Object();
    public Foo1() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            a = 1;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while(a != 1) {
                lock.wait();
            }

            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            a = 2;
            lock.notifyAll();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (a != 2) {
                lock.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();

        }

    }
}