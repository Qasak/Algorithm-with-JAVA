package leetcode.SpringRecruit.并发.线程交替执行;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/7 16:00
 */
public class Q1114_按序打印_ReentrantLock {
    public static void main(String[] args) throws InterruptedException {
        Foo f = new Foo();
        f.first(new Work(1));
        f.third(new Work(3));
        f.second(new Work(2));
    }
}
class Foo {
    int a = 0;
    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        printFirst.run();
        c1.signalAll();
        a = 1;
        lock.unlock();
        // printFirst.run() outputs "first". Do not change or remove this line.
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        while(a != 1) {
//            System.out.println("c1 waiting");
            c1.await();
        }
        printSecond.run();
        c2.signalAll();
        // printFirst.run() outputs "first". Do not change or remove this line.
        a = 2;
        lock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        while(a != 2) {
//            System.out.println("c2 waiting");
            c2.await();
        }
        printThird.run();
        lock.unlock();
        // printThird.run() outputs "third". Do not change or remove this line.
    }
}