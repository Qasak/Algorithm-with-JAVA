package leetcode.SpringRecruit.并发.线程交替执行;

import java.util.concurrent.Semaphore;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/7 17:25
 */
public class Q1115_交替打印_Semaphore {
}
//信号量 适合控制顺序
class FooBar4 {
    Semaphore s1 = new Semaphore(1);
    Semaphore s2 = new Semaphore(0);
    private int n;

    public FooBar4(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            s1.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            s2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            s2.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            s1.release();
        }
    }
}