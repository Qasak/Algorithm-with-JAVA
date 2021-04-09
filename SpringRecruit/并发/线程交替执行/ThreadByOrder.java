package leetcode.SpringRecruit.并发.线程交替执行;

import lombok.SneakyThrows;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/7 15:08
 */
// 顺序执行
public class ThreadByOrder {
    public static void main(String[] args) {
        ThreadPoolExecutor tp = new ThreadPoolExecutor(
                10,
                200,
                200,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(200),
                Executors.defaultThreadFactory());
        for(int i = 0; i < 10; i++) {
            tp.execute(new Work(i));
        }
        tp.shutdown();
    }
}
class Work implements Runnable {
    private int id;
    public Work(int i) {
        id = i;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(id);
    }
}
