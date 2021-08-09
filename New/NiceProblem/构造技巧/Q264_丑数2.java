package leetcode.NiceProblem.构造技巧;

import java.util.PriorityQueue;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/9 15:52
 */
public class Q264_丑数2 {
    public int nthUglyNumber(int n) {
        int[] arr = new int[]{2, 3, 5};
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i = 0; i < 3; i++) {
            q.offer(new int[]{arr[i], i, 0});
        }
        int[] ans = new int[n];
        ans[0] = 1;
        for(int j = 1; j < n;) {
            int[] t = q.poll();
            int val = t[0], i = t[1], idx = t[2];
            // 去重
            if(val > ans[j - 1]) {
                ans[j++] = val;
            }
            q.offer(new int[]{ans[idx + 1] * arr[i], i, idx + 1});
        }
        return ans[n - 1];
    }
}
