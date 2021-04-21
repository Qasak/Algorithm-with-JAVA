package leetcode.template.Window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/3 11:08
 */
public class Q480_MedianSlidingWindow {
    // 1. 暴力
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        boolean flag = true;
        if((k % 2) == 0) {
            flag = false;
        }
        double[] ans = new double[n - k + 1];
        int idx = 0;
        // [l, r)
        for(int l = 0, r = k; r <= n; ++r, ++l) {
            // k
            long[] window = new long[k];
            for(int j = l; j < r; j++) {
                window[j - l] = nums[j];
            }
            // klogk
            Arrays.sort(window);
            double m = 0;
            if(flag) {
                m = window[k / 2];
            } else {
                m = (double)(window[k / 2] + window[(k - 1) / 2]) / 2;
            }

            ans[idx++] = m;
        }
        return ans;
    }
    // 1. 双优先队列 + 延迟删除

    public double[] medianSlidingWindow1(int[] nums, int k) {
        return null;
    }
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        int[] b = Arrays.copyOfRange(a, 0, 2);
        System.out.println(Arrays.toString(b));
        ArrayList<Integer> c = new ArrayList<>();
        c.add(3);
        c.add(1);
        System.out.println(Collections.binarySearch(c, 2));
    }
}
