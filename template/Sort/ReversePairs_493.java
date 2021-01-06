package leetcode.template.Sort;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/11/28 14:33
 * 数组nums, 若i < j 且 nums[i] > 2 * nums[j]
 * 称(i, j)为重要翻转对
 * 返回数组中重要翻转对的数量
 *
 * 输入: [1,3,2,3,1]
 * 输出: 2
 *
 * 输入: [2,4,3,5,1]
 * 输出: 3
 *
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 *
 *
 */

import java.util.ArrayList;
import java.util.List;

/**
 * */
// 归并排序：同数组中的逆序对
public class ReversePairs_493 {
    int cnt = 0;
    int[] tmp;
    public int reversePairs(int[] nums) {
        int n = nums.length;
        tmp = new int[n];
        mergeSort(nums, 0, n - 1);
        return cnt;
    }
    private void mergeSort(int[] nums, int l, int r) {
        if(l < r) {
            int m = l + (r - l) / 2;
            mergeSort(nums, l, m);
            mergeSort(nums, m + 1, r);
            int i = l;
            int p1 = l;
            int p2 = m + 1;
            int n = r - l + 1;
            while(p1 <= m && p2 <= r) {
                // [l, m] [m + 1, r]
                // p1及后序数字都比nums[p2]大
                if(nums[p1] > nums[p2]) {
                    cnt += m - p1 + 1;
                    tmp[i++] = nums[p2++];
                } else {
                    tmp[i++] = nums[p1++];
                }
            }
            while(p1 <= m) {
                tmp[i++] = nums[p1++];
            }
            while(p2 <= r) {
                tmp[i++] = nums[p2++];
            }
            for(int k = 0; k < n; k++) {
                nums[k + l] = tmp[k + l];
            }
        }
    }
    public static void main(String[] args) {
        ReversePairs_493 s = new ReversePairs_493();
        int[] nums1 = new int[]{1,3,2,3,1};
        int[] nums2 = new int[]{2,4,3,5,1};
        System.out.println(s.reversePairs(nums1));

    }
}
