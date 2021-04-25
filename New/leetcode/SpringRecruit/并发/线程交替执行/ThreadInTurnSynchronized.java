package leetcode.SpringRecruit.并发.线程交替执行;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/7 15:09
 */
public class ThreadInTurnSynchronized {
    // 通过 synchronized 同步两个方法，每次只能有一个线程进入，每打印一个数，就释放锁，
    // 另一个线程进入，拿到锁，打印，唤醒另一个线程，然后挂起自己。
    public static void main(String[] args) throws InterruptedException {
        final ThreadInTurnSynchronized threadInTurnSynchronized = new ThreadInTurnSynchronized();
        Thread t1 = new Thread(threadInTurnSynchronized::print1);
        Thread t2 = new Thread(threadInTurnSynchronized::print2);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    public synchronized void print2() {
        for (int i = 1; i <= 100; i += 2) {
            System.out.println(i);
            this.notify();
            try {
                this.wait();
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
    }

    public synchronized void print1() {
        for (int i = 0; i <= 100; i += 2) {
            System.out.println(i);
            this.notify();
            try {
                this.wait();
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
    }
}
