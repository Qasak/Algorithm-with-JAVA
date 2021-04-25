package leetcode.SpringRecruit.ArrayAndString;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/24 18:26
 */

class Solution {
    // 或者  无序数组中找中位数
    private Random rand = new Random();
    public int findKthLargest(int[] nums, int k) {
        // 1 2 2 3 3 4 5 5 6

        // 1 2 3 4 5 6
        int n = nums.length;
        quickSelect(nums, 0, n - 1, n - k);
        // System.out.println(Arrays.toString(nums));
        return nums[n - k];
    }
    public int quickSelect(int[] nums, int l, int r, int k) {
        int p = partition(nums, l, r);
        if(p == k) {
            return p;
        }
        if(p < k) {
            return quickSelect(nums, p + 1, r, k);
        } else {
            return quickSelect(nums, l, p - 1, k);
        }
    }

    public int partition(int[] nums, int l, int r) {
        swap(nums, l + rand.nextInt(r - l + 1), r);
        int i = l - 1;
        for(int j = l; j < r; j++) {
            if(nums[j] < nums[r]) {
                swap(nums, j, ++i);
            }
        }
//        int i = l - 1, j = l, k = r - 1;
        // while(j <= k) {
        //     if(nums[j] <= nums[r]) {
        //         swap(nums, ++i, j++);
        //     } else {
        //         swap(nums, j, k--);
        //     }
        // }
        swap(nums, i + 1, r);

        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

public class Q215_数组中的第k个最大元素 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        System.out.println(s.findKthLargest(nums, k));
    }
}
