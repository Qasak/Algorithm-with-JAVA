package leetcode.contest.Rating1800.模拟;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/5 17:31
 */
public class Q1834_单线程CPU {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] t = new int[n][3];
        for(int i = 0; i < n; i++) {
            int[] task = tasks[i];
            t[i][0] = task[0];
            t[i][1] = task[1];
            t[i][2] = i;
        }
        // 按入队时间排序
        Arrays.sort(t, (a, b) -> (a[0] - b[0]));
        int[] ans = new int[n];
        // 答案顺序下标
        int idx = 0;
        // 任务下标
        int i = 0;
        // 当前时间
        int cur = 1;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]));
        while(idx < n) {
            // 当前可以入队的所有任务，全部入队
            while(i < n && t[i][0] <= cur) {
                q.offer(t[i++]);
            }
            if(q.isEmpty()) {
                cur = t[i][0];
            } else {
                int[] tt = q.poll();
                cur += tt[1];
                ans[idx++] = tt[2];
            }
        }
        return ans;
    }
}
