package leetcode.SpringRecruit.并发.线程交替执行;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/7 15:39
 */
public class ThreadInTurnCAS {
    static AtomicInteger cxsNum = new AtomicInteger(0);
    static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (; cxsNum.get() < 100; ) {
                if (!flag && (cxsNum.get() == 0 || cxsNum.incrementAndGet() % 2 == 0)) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {

                    }

                    System.out.println(cxsNum.get());
                    flag = true;
                }
            }
        }
        );

        Thread t2 = new Thread(() -> {
            for (; cxsNum.get() < 100; ) {
                if (flag && (cxsNum.incrementAndGet() % 2 != 0)) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {

                    }

                    System.out.println(cxsNum.get());
                    flag = false;
                }
            }
        }
        );

        t1.start();
        t2.start();
    }
}
