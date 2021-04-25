package leetcode.SpringRecruit.ArrayAndString;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/19 14:38
 */
public class Q280_摆动序列 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
            swap(nums, i, i + 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
