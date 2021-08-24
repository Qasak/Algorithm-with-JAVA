package leetcode.template.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/20 23:58
 */
public class Q152_乘积最大子数组 {
	    public int maxProduct(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        // i 前的最大正子数组
        int f = nums[0];
        // i 前的最小负子数组
        int g = nums[0];

        for(int i = 1; i < n; i++) {
            int ff = f, gg = g;
            f = Math.max(ff * nums[i], Math.max(gg * nums[i], nums[i]));
            g = Math.min(ff * nums[i], Math.min(gg * nums[i], nums[i]));
            ans = Math.max(f, ans);
        }
        return ans;
    }
}
