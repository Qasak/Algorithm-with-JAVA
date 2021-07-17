package leetcode.contest.NiceProblem.线性DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/17 13:48
 */
public class Q53_最大连续子数组和 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        // f[i] i下标前的子数组最大值
        int[] f = new int[n];
        f[0] = nums[0];
        int ans = nums[0];
        for(int i = 1; i < n; i++) {
            f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
}
