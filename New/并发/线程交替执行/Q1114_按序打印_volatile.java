package leetcode.SpringRecruit.并发.线程交替执行;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/7 16:24
 */
public class Q1114_按序打印_volatile {

}
class Foo2 {
    private volatile int a = 0;
    public Foo2() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        a++;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (a != 1) {

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        a++;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (a != 2) {

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
