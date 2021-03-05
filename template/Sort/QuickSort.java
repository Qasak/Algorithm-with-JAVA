package leetcode.template.Sort;

import java.util.Random;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/23 12:15
 */
public class QuickSort {
    Random rand;
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public void quickSort(int[] nums, int l, int r) {
        if(l >= r) {
            return;
        }
        int p = RandomPartition(nums, l, r);
        quickSort(nums, l, p - 1);
        quickSort(nums, p + 1, r);
    }
    public int RandomPartition(int[] nums, int l, int r) {
        int x = rand.nextInt(r - l + 1);
        swap(nums, r, l + x);
        return partition(nums, l, r);
    }
    public int partition(int[] nums, int l, int r) {
        int i = l - 1;
        for(int j = i + 1; j < r; j++) {
            if(nums[j] < nums[r]) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, ++i, r);
        return i;
    }
    public int[] sortArray(int[] nums) {
        rand = new Random();
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
}
