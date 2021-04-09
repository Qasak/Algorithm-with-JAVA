package leetcode.SpringRecruit.并发.线程交替执行;

import leetcode.JavaBasic.OOP.抽象类;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/7 16:58
 */
public class Q1115_交替打印FooBar_AtomicInteger {
    public static void main(String[] args) throws InterruptedException {
        FooBar1 f = new FooBar1(10);
        f.foo(new printFoo());
        f.bar(new printBar());
    }
}
class FooBar1 {
    AtomicInteger a = new AtomicInteger(0);
    int n;

    public FooBar1(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (a.get() % 2 == 1) { }
            printFoo.run();
            a.getAndIncrement();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (a.get() % 2 == 0) { }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            a.getAndIncrement();
        }
    }
}
class printFoo implements Runnable {
    @Override
    public void run() {
        System.out.print("Foo");
    }
}
class printBar implements Runnable {
    @Override
    public void run() {
        System.out.print("Bar");
    }
}
