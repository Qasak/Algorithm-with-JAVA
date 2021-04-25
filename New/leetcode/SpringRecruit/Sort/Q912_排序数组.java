package leetcode.SpringRecruit.Sort;

import java.util.Random;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/19 13:27
 */
public class Q912_排序数组 {
    // 快排
    class Solution {
        Random rand = new Random();
        public int[] sortArray(int[] nums) {
            int n = nums.length;
            quickSort(nums, 0, n - 1);
            return  nums;
        }

        public void quickSort(int[] nums, int l, int r) {
            if(l >= r) {
                return;
            }
            int p = partition(nums, l, r);
            quickSort(nums, l, p - 1);
            quickSort(nums, p + 1, r);
        }

        public int partition(int[] nums, int l, int r) {
            swap(nums, rand.nextInt(r - l + 1) + l, r);
            int i = l - 1, j = l, k = r - 1;
            while(j <= k) {
                if(nums[j] <= nums[r]) {
                    swap(nums, j++, ++i);
                } else {
                    swap(nums, j, k--);
                }
            }
            swap(nums, i + 1, r);
            return i + 1;
        }

        public void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }




    // 归并
    class Solution1 {
        private int[] tmp;
        public int[] sortArray(int[] nums) {
            int n = nums.length;
            tmp = new int[n];
            mergeSort(nums, 0, n - 1);
            return  nums;
        }
        public void mergeSort(int[] nums, int l, int r) {
            if(l >= r) {
                return;
            }
            int n = nums.length;
            int mid = (l + r) >>> 1;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            int i = l, j = mid + 1;
            int idx = l;
            while(i <= mid && j <= r) {
                if(nums[i] <= nums[j]) {
                    tmp[idx++] = nums[i++];
                } else {
                    tmp[idx++] = nums[j++];
                }
            }
            while(i <= mid) {
                tmp[idx++] = nums[i++];
            }
            while(j <= r) {
                tmp[idx++] = nums[j++];
            }
            for(int k = l; k <= r; k++) {
                nums[k] = tmp[k];
            }
        }
    }
    public static void main(String[] args) {
        Random rand = new Random();
        rand.nextInt(2);
    }
}
