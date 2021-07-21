package leetcode.contest.Rating1800.DP;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/19 9:54
 */
public class Q795_区间子数组个数 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        // 以i结尾的满足条件的子数组的个数
        int[] f = new int[n];
        int pre = -1;
        if(nums[0] >= left && nums[0] <= right) {
            f[0] = 1;
        } else if(nums[0] > right) {
            pre = 0;
        }
        for(int i = 1; i < n; i++) {
            if(nums[i] > right) {
                pre = i;
            }
            // nums[i] <= right
            if(nums[i] >= left && nums[i] <= right) {
                f[i] = i - pre;
            }
            // nums[i] < left
            if(nums[i] < left) {
                f[i] = f[i - 1];
            }
        }
        // System.out.println(Arrays.toString(f));
        return Arrays.stream(f).sum();
    }
}
