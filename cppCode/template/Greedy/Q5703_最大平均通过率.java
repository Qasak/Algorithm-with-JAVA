package leetcode.template.Greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/14 12:19
 */
public class Q5703_最大平均通过率 {
    public double maxAverageRatio(int[][] classes, int ex) {
        PriorityQueue<double[]> pq = new PriorityQueue((o1, o2) -> {
            double[] a = (double[]) o1;
            double[] b = (double[]) o2;
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
