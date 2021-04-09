package leetcode.SpringRecruit.并发.线程交替执行;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/7 16:47
 */
public class Q1115_交替打印FooBar_synchronized {
}
class FooBar {
    private int n;
    private Object lock = new Object();
    private int a = 0;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized(lock) {
                while(a % 2 == 1) {
                    lock.wait();
                }
                // System.out.println("foo " + a);

                printFoo.run();
                a++;
                lock.notifyAll();
                // printFoo.run() outputs "foo". Do not change or remove this line.
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized(lock) {
                while(a % 2 == 0) {
                    lock.wait();
                }
                // System.out.println("bar " + a);

                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                a++;
                lock.notifyAll();
            }
        }
    }
}
