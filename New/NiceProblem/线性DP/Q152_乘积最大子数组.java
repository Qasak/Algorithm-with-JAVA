package leetcode.contest.NiceProblem.线性DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/17 14:05
 */
public class Q152_乘积最大子数组 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = nums[0];
        g[0] = nums[0];
        int ans = nums[0];
        for(int i = 1; i < n; i++) {
            if(nums[i] < 0) {
                f[i] = Math.max(nums[i], nums[i] * g[i - 1]);
                g[i] = Math.min(nums[i], nums[i] * f[i - 1]);
            } else {
                g[i] = Math.min(nums[i], nums[i] * g[i - 1]);
                f[i] = Math.max(nums[i], nums[i] * f[i - 1]);
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
}
