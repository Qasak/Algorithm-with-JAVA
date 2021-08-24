package leetcode.template.Sort;

import java.util.Random;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/24 15:41
 */
public class Q_快排简洁版 {
    Random rand = new Random();
    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    void quickSort(int[] nums, int l, int r) {
        if(l >= r) {
            return;
        }
        swap(nums, r, l + rand.nextInt(r - l + 1));
        int i = l - 1, j = l, k = r;
        while(j < k) {
            if(nums[j] < nums[r]) {
                swap(nums, ++i, j++);
            } else if(nums[j] > nums[r]) {
                swap(nums, --k, j);
            } else {
                j++;
            }
        }
        quickSort(nums, l, i);
        quickSort(nums, k, r);
    }
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
}
