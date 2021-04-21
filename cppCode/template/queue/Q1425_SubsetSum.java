package leetcode.template.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/20 21:08
 * 给你一个整数数组nums和一个整数k，请你返回 非空子序列元素和的最大值，子序列需要满足：子序列中每两个 相邻的整数nums[i]和nums[j]，
 * 它们在原数组中的下标i和j满足i < j且 j - i <= k 。
 *
 * 输入：nums = [10,2,-10,5,20], k = 2
 * 输出：37
 * 解释：子序列为 [10, 2, 5, 20] 。
 *
 */
public class Q1425_SubsetSum {
    public int constrainedSubsetSum(int[] nums, int k) {
        // dp[i] : 以i为结尾的数组的最大和
        // dp[i]表示以nums[i]结尾的满足限制的最大子序和
        //那么递推公式就是：dp[i] = nums[i] + max(dp[i - k: i], 0)
        //时间复杂度是O(n*k)，会超时
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> q = new LinkedList<>();
        q.offerLast(0);
        dp[0] = nums[0];
        int ans = nums[0];
        for(int i = 1; i < n; i++) {
            while(!q.isEmpty() && q.peekFirst() < i - k) {
                q.pollFirst();
            }
            dp[i] = Math.max(dp[q.peekFirst()] + nums[i], nums[i]);
            ans = Math.max(ans, dp[i]);
            while(!q.isEmpty() && dp[q.peekLast()] <= dp[i]) {
                q.pollLast();
            }
            q.offerLast(i);
        }
        return ans;
    }
}
