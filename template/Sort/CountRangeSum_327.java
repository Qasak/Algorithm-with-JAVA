package leetcode.template.Sort;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/9 11:39
 *
 * 给定一个整数数组nums，返回区间和在[lower, upper]之间的个数，包含lower和upper。
 * 区间和S(i, j)表示在nums中，位置从i到j的元素之和，包含i和j(i ≤ j)。
 * 示例:
 *
 * 输入: nums = [-2,5,-1], lower = -2, upper = 2,
 * 输出: 3
 * 解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
 *
 *
 *
 * 设前缀和数组为 preSum，则问题等价于求所有的下标对 (i,j)
 * 前缀和数组中[i, j]的和==Sum[j + 1] - Sum[i] 属于 [lower, upper]
 *
 * [-2, 5, -1]
 * 这个前缀和数组并非是有序的
 * [0, -2, 3, 2]
 *
 */
public class CountRangeSum_327 {
    int lower;
    int upper;
    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        int n = nums.length;
        long[] sum = new long[n + 1];
        long s = 0;
        for(int i = 0; i < n; i++) {
            s += nums[i];
            sum[i + 1] = s;
        }
        return mergeSort(sum, 0, sum.length - 1);

    }
    private int mergeSort(long[] sum, int l, int r) {
        if(l == r) {
            return 0;
        }
        else {
            int m = l + (r - l) / 2;
            int n1 = mergeSort(sum, l, m);
            int n2 = mergeSort(sum, m + 1, r);
            int ret = n1 + n2;


            // TODO
            /**
             * 两个升序排列的数组 n1, n2
             * 求满足Sum[j] - Sum[i] 属于 [lower, upper]的下标对个数
             * 在已知两个数组均为升序的情况下，这一问题是相对简单的
             * sum[i, m]是递增的，p1, p2只可能向右移动
             * */
            int i = l;
            int p1 = m + 1;
            int p2 = m + 1;
            while(i <= m) {
                while(p1 <= r && sum[p1] - sum[i] < lower) {
                    p1++;
                }
                while(p2 <= r && sum[p2] - sum[i] <= upper) {
                    p2++;
                }
                ret += p2 - p1;
                i++;
            }


            merge(sum, l, r);
            return ret;
        }
    }
    private void merge(long[] sum, int l, int r) {
        int m = l + (r - l) / 2;
        int p1 = l;
        int p2 = m + 1;
        int n = r - l + 1;
        long[] tmp = new long[n];
        int i = 0;

        while(p1 <= m && p2 <= r) {
            tmp[i++] = sum[p1] < sum[p2] ? sum[p1++] : sum[p2++];
        }
        while(p1 <= m) {
            tmp[i++] = sum[p1++];
        }
        while(p2 <= r) {
            tmp[i++] = sum[p2++];
        }
        for(int k = 0; k < n; k++) {
            sum[k + l] = tmp[k];
        }
    }

    public static void main(String[] args) {

    }
}
