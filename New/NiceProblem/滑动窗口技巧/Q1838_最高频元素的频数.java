package leetcode.contest.NiceProblem.滑动窗口技巧;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/19 9:33
 */
public class Q1838_最高频元素的频数 {
    // 排序 + 前缀和 + 滑动窗口
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0, r = 0;
        long sum = 0;
        int ans = 0;
        for(; r < n; r++) {
            sum += nums[r];
            while(k < (long)(nums[r] * (r - l + 1)) - sum) {
                sum -= nums[l++];
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
