package leetcode.SpringRecruit.并发.线程交替执行;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/7 17:17
 */
public class Q1115_交替打印FooBar_ReentrantLock {

}
class FooBar2 {
    private AtomicInteger a = new AtomicInteger(0);
    private ReentrantLock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    int n;
    public FooBar2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (a.get() % 2 == 1) {
                    c1.await();
                }
                printFoo.run();
                a.getAndIncrement();
                c2.signal();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {

            lock.lock();
            try {
                while (a.get() % 2 == 0) {
                    c2.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                a.getAndIncrement();
                c1.signal();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }
}
