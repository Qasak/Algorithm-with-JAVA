package leetcode.HighFreq;

import AlibabaManual.集合处理.forEach循环.使用Iterator;
import sun.security.rsa.RSASignature;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/28 11:06
 */
public class Q4_两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int k = (n + m + 1) / 2;
        if(n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int l = 0, r = n;
        while(l < r) {
            int m1 = (l + r) >>> 1;
            int m2 = k - m1;
            if(nums1[m1] < nums2[m2 - 1]) {
                l = m1 + 1;
            } else {
                r = m1;
            }
        }

        int a = Math.max(l - 1 >= 0 ? nums1[l - 1] : Integer.MIN_VALUE,
                k - l - 1 >= 0 ? nums2[k - l - 1] : Integer.MIN_VALUE);
        int b = Math.min(l < n ? nums1[l] : Integer.MAX_VALUE,
                k - l < m ? nums2[k - l] : Integer.MAX_VALUE);
        if((n + m) % 2 == 1) {
            return a * 1.0;
        }
        return (a + b) * 0.5;
    }

    public static void main(String[] args) {


    }
}
