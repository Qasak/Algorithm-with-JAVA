package leetcode.template.DP.MaxSubArr;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/13 11:15
 */
public class Q152_MaxProduct {
    // 并不是单调的(有正负， 最大可以直接变到最小, 最小也可直接变到最大)
    // dp
    public int maxProduct(int[] nums) {
        int n = nums.length;
        // 以i结尾的数组 子数组最大乘积
        int[] max = new int[n];
        // 以i结尾的数组 子数组最小乘积
        int[] min = new int[n];

        //
        int ans = nums[0];
        max[0] = min[0] = nums[0];
        for(int i = 1; i < n; i++) {
            max[i] = Math.max(Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            min[i] = Math.min(Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            ans = Math.max(ans, max[i]);
        }
        return ans;
    }
    public int maxProduct1(int[] nums) {
        int n = nums.length;
        // 以i结尾的数组 子数组最大乘积
        int max, min, ans;
        max = min = ans = nums[0];
        for(int i = 1; i < n; i++) {
            int tmax = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(tmax * nums[i], min * nums[i]), nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }
    // greedy
    // 1.负数为偶数个，则整个数组的各个值相乘为最大值；
    //
    //2.负数为奇数个，则从左边开始，乘到最后一个负数停止有一个“最大值”，从右边也有一个“最大值”，比较，得出最大值。
    public int maxProduct2(int[] nums) {
        int prod = 1;
        int n = nums.length;
        int ans = nums[0];
        for(int i = 0; i < n; i++) {
            prod *= nums[i];
            ans = Math.max(ans, prod);
            prod = prod == 0 ? 1 : prod;
        }
        prod = 1;
        for(int i = n - 1; i >= 0; i--) {
            prod *= nums[i];
            ans = Math.max(ans, prod);
            prod = prod == 0 ? 1 : prod;
        }
        return ans;
    }
}
