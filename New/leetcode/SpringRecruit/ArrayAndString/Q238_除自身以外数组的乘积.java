package leetcode.SpringRecruit.ArrayAndString;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/22 20:39
 */
public class Q238_除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for(int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int post = nums[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            ans[i] = ans[i] * post;
            post *= nums[i];
        }
        return ans;
    }
}
