package leetcode.contest.NiceProblem;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/22 15:23
 */
public class Q31_下一个排列 {
    // 输入：nums = [1,2,3]
    // 输出：[1,3,2]
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return;
        }
        int i = n - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if(i < 0) {
            Arrays.sort(nums);
            return;
        }
        int j = n - 1;
        while(j > i && nums[j] <= nums[i]) {
            j--;
        }
        swap(nums, i, j);
        Arrays.sort(nums, i + 1, n);
    }
    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
