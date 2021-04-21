package leetcode.template.DP.Jump;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/27 20:06
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 */
public class Q45_JumpII {
    // 贪心
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
    // dp
    public int jump1(int[] nums) {
        if(nums.length == 1) {
            return 1;  // 一个格子跳啥了还
        }
        int[] step = new int[nums.length], dp = new int[nums.length];
        step[1] = nums[0];  // 第一步可以达到的最大位置，前面已经保证至少 2 格
        for(int i = 1; i < nums.length; ++i) {
            dp[i] = step[dp[i-1]] >= i ? dp[i-1] : dp[i-1]+1;
            // 假如前一个格子所花的步数能达到的最大位置 >= 当前位置，即前一个步数也可以到当前位置
            // 不能到达。不能到达就再走一步！
            if(dp[i]+1 < nums.length)  // 步数可能溢出，但是溢出的数据是没有意义的（一定可以在 n-1 步到达终点）
            {
                step[dp[i]+1] = Math.max(step[dp[i]+1], i+nums[i]);
            }
            // 这里计算的是从当前格子在走一步所能到达的最大距离
            // 假如超过之前存储的最大步数，则更新
        }
        return dp[nums.length-1];
    }
    // BFS
    public int jump2(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.offer(0);
        vis[0] = true;
        // 2-> 3,1
        // 3 -> 1, 4
        //
        while(!q.isEmpty()) {
            int m = q.size();
            for(int i = 0; i < m; i++) {
                int t = q.poll();
                if(t == n - 1){
                    break;
                }
                int len = nums[t];
                for(int j = 1; j <= len && t + j < n; j++) {
                    if(!vis[t + j]) {
                        vis[t + j] = true;
                        q.offer(t + j);
                    }
                }
            }
            cnt++;
        }
        return cnt - 1;
    }
}
