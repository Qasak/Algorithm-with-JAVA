package leetcode.SpringRecruit.ArrayAndString;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/21 13:53
 */
public class Q4_两个正序数组的中位数 {
    // 1. 合并两个有序数组
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] tmp = new int[n + m];
        int i = 0, j = 0;
        int idx = 0;
        while(i < n && j < m) {
            if(nums1[i] < nums2[j]) {
                tmp[idx++] = nums1[i++];
            } else {
                tmp[idx++] = nums2[j++];
            }
        }
        while(i < n) {
            tmp[idx++] = nums1[i++];
        }
        while(j < m) {
            tmp[idx++] = nums2[j++];
        }
        return  ((double)tmp[(n + m) / 2] + (double)tmp[(n + m - 1) / 2]) / 2;
    }
    // 1.1 空间 O(1)

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int len = n + m;
        int j = 0, k = 0;
        int a = 0, b = 0;
        boolean flag = (((m + n) % 2) == 1);
        for(int i = 0; i <= len / 2; i++) {
            if(i < (len - 1) / 2) {
                if(j < n && (k >= m || nums1[j] < nums2[k])) {
                    j++;
                } else {
                    k++;
                }
                continue;
            }
            if(i == (len - 1) / 2) {
                if(j < n && (k >= m || nums1[j] < nums2[k])) {
                    a = nums1[j];
                    if(!flag) {
                        j++;
                    }
                } else {
                    a = nums2[k];
                    if(!flag) {
                        k++;
                    }
                }

            }
            if(i == len / 2) {
                if(j < n && (k >= m || nums1[j] < nums2[k])) {
                    b = nums1[j];
                } else {
                    b = nums2[k];
                }
            }

        }
        // System.out.println(a + " " + b);
        return (a * 1.0 + b * 1.0) / 2;
    }
    // 2.二分查找

    // 3.划分数组
    int m;
    int n;
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        m = nums1.length;
        n = nums2.length;
        int len = m + n;
        double a = 1.0 * findKth(nums1, nums2, 0, 0, (len + 1) / 2);
        double b = 1.0 * findKth(nums1, nums2, 0, 0, (len + 2) / 2);
        // System.out.println(a + " " + b);

        return (a + b) / 2;
    }

    // 返回两个数组中第k小的元素
    public int findKth(int[] nums1, int[] nums2, int i, int j, int k) {
        if(i == m) {
            return nums2[j + k - 1];
        }
        if(j == n) {
            return nums1[i + k - 1];
        }
        if(k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }

        int a = i + k / 2 - 1 < m ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int b = j + k / 2 - 1 < n ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if(a < b) {
            return findKth(nums1, nums2, i + k / 2, j, k - k / 2);
        } else {
            return findKth(nums1, nums2, i, j + k / 2, k - k / 2);
        }
    }
}
