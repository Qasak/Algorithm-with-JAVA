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

    // 前缀和
    public int maxSubArray1(int[] nums) {
        // 最小前缀和
        int min = 0;
        int ans = Integer.MIN_VALUE;
        // 当前前缀和
        int pre = 0;
        // 对于每一个当前前缀和，都存在一个最小前缀和与之对应
        // 其差值即当前最大连续子数组的和
        for(int i = 0 ; i < nums.length ; i ++){
            pre += nums[i];
            ans = Math.max(ans, pre - min);
            min = Math.min(min, pre);
        }
        return ans;
    }
}
