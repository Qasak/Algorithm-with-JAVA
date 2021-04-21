package leetcode.template.DoublePtr;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/31 17:10
 */
public class Q1099_TwoSumLesss {
    public int twoSumLessThanK(int[] nums, int k) {
        // 34 -> [0, 25]
        int sum = -1;
        // [1,8,23,24,33,34,54,75]
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0;
        int r = n - 1;
        while(l < r) {
            if(nums[l] + nums[r] >= k) {
                r--;
            } else {
                sum = Math.max(sum, nums[l] + nums[r]);
                l++;
            }
        }
        return sum;
    }
}
