package leetcode.contest.Rating1900;

import java.util.PriorityQueue;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/19 10:49
 */
public class Q1705_吃苹果的最大数目 {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        int n = apples.length;
        int ans = 0;
        for(int i = 0; i < 40001; i++) {
            if(i < n) {
                int[] tt = new int[2];
                // 个数:过期时间
                tt[0] = apples[i]; tt[1] = i + days[i];
                if(tt[0] > 0 && tt[1] > 0) {
                    pq.offer(tt);
                }
            }

            // 吃一个最早过期的
            while(!pq.isEmpty()) {
                int[] t = pq.poll();
                t[0]--;

                if(t[0] > 0 && t[1] > i) {
                    pq.offer(t);
                }
                if(t[0] >= 0 && t[1] > i) {
                    ans++;
                    break;
                }
            }
            if(i >= n && pq.isEmpty()) {
                break;
            }
        }
        return ans;
    }
}
