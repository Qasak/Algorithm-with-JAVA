package leetcode.SpringRecruit.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/15 11:00
 */
public class Q198_打家劫舍 {
    public int rob(int[] nums) {
        int n = nums.length;
        // 偷当前
        int[] a = new int[n];
        // 不偷当前
        int[] b = new int[n];
        a[0] = nums[0];

        for(int i = 1; i < n; i++) {
            a[i] = b[i - 1] + nums[i];
            b[i] = Math.max(a[i - 1], b[i - 1]);
        }
        return Math.max(a[n - 1], b[n - 1]);

    }
}
