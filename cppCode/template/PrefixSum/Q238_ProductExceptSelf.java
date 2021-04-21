package leetcode.template.PrefixSum;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/14 11:35
 */
public class Q238_ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        // 1     2     3  4
        // ans[i] = prod
        // <- prod *= nums[i]
        // 24    12    4  1
        // ->
        // 24    12    8  6

        // 1     2    3    4
        // 1     1    2    6
        //

        int n = nums.length;
        if(n == 0) {
            return new int[]{};
        }

        int[] ans = new int[n];
        int prod = 1;
        for(int i = n - 1; i >= 0; i--) {
            ans[i] = prod;
            prod *= nums[i];
        }
        prod = 1;
        for(int i = 0; i < n; i++) {
            ans[i] *= prod;
            prod *= nums[i];
        }
        return ans;
    }
    // 降低常数 (反而更慢了)
    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int left = 1;
        int right = 1;

        for(int i = 0; i < n; i++) {
            ans[i] *= left;
            ans[n - i - 1] *= right;
            right *= nums[n - i - 1];
            left *= nums[i];

        }
        return ans;
    }
}
