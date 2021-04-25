package leetcode.SpringRecruit.并发.线程交替执行;

import java.util.concurrent.Semaphore;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/8 16:45
 */
public class Q1226_哲学家进餐_Semaphore {
    class DiningPhilosophers {
        private Semaphore[] forks = new Semaphore[5];

        public DiningPhilosophers() {
            for(int i = 0; i < 5; i++) {
                forks[i] = new Semaphore(1);
            }
        }

        // call the run() method of any runnable to execute its code
        public void wantsToEat(int id,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
            forks[id].acquire();
            forks[(id + 1) % 5].acquire();
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
            forks[id].release();
            forks[(id + 1) % 5].release();
        }
    }
}
