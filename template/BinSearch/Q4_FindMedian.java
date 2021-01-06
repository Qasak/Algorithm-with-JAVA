package leetcode.template.BinSearch;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/4 10:43
 */
public class Q4_FindMedian {
    // 1 合并
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;

        int[] arr = new int[n];
        int p = 0;
        int i = 0, j = 0;
        for(; i < n1 && j < n2; ) {
            if(nums1[i] < nums2[j]) {
                arr[p++] = nums1[i++];
            } else {
                arr[p++] = nums2[j++];
            }
        }
        for(;i < n1;) {
            arr[p++] = nums1[i++];
        }
        for(;j < n2;) {
            arr[p++] = nums2[j++];
        }
        // 1,2,3
        // 1,2,3,4
        return (double) (arr[(n - 1) / 2] + arr[n / 2]) / 2;
    }
    // 2 不合并
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int idx1 = (n - 1) / 2;
        int idx2 = n / 2;
        int p = 0;
        int i = 0, j = 0;
        double ans = 0;
        for(; i < n1 && j < n2; p++) {
            if(nums1[i] < nums2[j]) {
                if(p == idx1 || p == idx2) {
                    ans += nums1[i];
                }
                i++;
            } else {
                if(p == idx1 || p == idx2) {
                    ans += nums2[j];
                }
                j++;
            }
        }
        for(;i < n1; p++) {
            if(p == idx1 || p == idx2) {
                ans += nums1[i];
            }
            i++;
        }
        for(;j < n2; p++) {
            if(p == idx1 || p == idx2) {
                ans += nums2[j];
            }
            j++;
        }
        // 1,2,3
        // 1,2,3,4
        return ((n & 1) == 1) ? ans : ans / 2;
    }
    // 3 第k小：二分

}
