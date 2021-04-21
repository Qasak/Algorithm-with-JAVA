package leetcode.template.queue;

import java.util.PriorityQueue;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/21 12:32
 */
public class Q1792_最大平均通过率 {
    public double maxAverageRatio(int[][] classes, int ex) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((double[] a, double[] b) -> {
            if(a[0] == b[0] && a[1] == b[1]) {
                return 0;
            }
            if(((a[0] + 1) / (a[1] + 1) - (a[0]) / (a[1])) > ((b[0] + 1) / (b[1] + 1) - (b[0]) / (b[1]))) {
                return -1;
            } else {
                return 1;
            }
        });
        for(int[] t : classes) {
            pq.offer(new double[]{t[0], t[1]});
        }

        for(int i = 0; i < ex; i++) {
            double[] t = pq.poll();
            pq.offer(new double[]{t[0] + 1, t[1] + 1});
        }
        double ans = 0;
        while(!pq.isEmpty()) {
            double[] t = pq.poll();
            ans +=  (t[0] / t[1]);
        }
        return ans / classes.length;
    }
}
