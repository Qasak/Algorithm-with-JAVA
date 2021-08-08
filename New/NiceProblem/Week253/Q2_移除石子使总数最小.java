package leetcode.contest.Week253;

import java.util.PriorityQueue;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/8 18:03
 */
public class Q2_移除石子使总数最小 {
    public int minStoneSum(int[] piles, int k) {
        int n = piles.length;
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> (b - a));
        for(int i : piles) {
            q.offer(i);
        }
        while(k-- > 0) {
            q.offer((q.poll() + 1) / 2);
        }
        // System.out.println(q);
        int sum = 0;
        while(!q.isEmpty()) {
            sum += q.poll();
        }
        return sum;
    }
}
