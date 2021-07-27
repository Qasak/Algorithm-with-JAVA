package leetcode.contest.Rating1800.贪心;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/24 15:32
 */
public class Q1775_通过最少操作次数使数组的和相等 {
    public int minOperations(int[] nums1, int[] nums2) {
        int sumA = Arrays.stream(nums1).sum();
        int sumB = Arrays.stream(nums2).sum();
        if(sumA == sumB) {
            return 0;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if(sumB > sumA) {
            int[] t = nums1;
            nums1 = nums2;
            nums2 = t;

            int tmp = sumA;
            sumA = sumB;
            sumB = tmp;
        }
        int diff = sumA - sumB;
        int n = nums1.length;
        int m = nums2.length;
        int cnt = 0;
        // System.out.println(sumA + " " + Arrays.toString(nums1));
        // System.out.println(sumB + " " + Arrays.toString(nums2));
        int i = n - 1, j = 0;
        while(diff > 0 && i >= 0 && j < m) {
            if(nums1[i] - 1 > 6 - nums2[j]) {
                diff -= nums1[i] - 1;
                i--;
            } else {
                diff -= 6 - nums2[j];
                j++;
            }
            cnt++;
        }
        while(diff > 0 && i >= 0) {
            diff -= nums1[i] - 1;
            i--;
            cnt++;
        }
        while(diff > 0 && j < m) {
            diff -= 6 - nums2[j];
            j++;
            cnt++;
        }
        if(diff > 0) {
            return -1;
        }
        return cnt;
    }
}
