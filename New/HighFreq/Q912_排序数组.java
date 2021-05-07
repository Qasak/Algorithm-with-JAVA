package leetcode.HighFreq;

import java.util.Random;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/27 14:04
 */
public class Q912_排序数组 {
    private Random rand = new Random();
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        quickSort(nums, 0, n - 1);
        return nums;
    }
    public void quickSort(int[] nums, int l, int r) {
        if(l > r) {
            return;
        }
        swap(nums, l + rand.nextInt(r - l + 1), r);
        int i = l - 1;
        for(int j = l; j < r; j++) {
            if(nums[j] < nums[r]) {
                swap(nums, j, ++i);
            }
        }
        swap(nums, i + 1, r);
        int p = i + 1;
        quickSort(nums, p + 1, r);
        quickSort(nums, l, p - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
