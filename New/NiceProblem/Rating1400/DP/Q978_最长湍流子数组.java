package leetcode.contest.Rating1400.DP;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/29 8:54
 */
public class Q978_最长湍流子数组 {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        // f[i]:以i结尾元素大于前一个元素的最长湍流子数组长度
        int[] f = new int[n];
        int[] g = new int[n];
        Arrays.fill(f, 1);
        Arrays.fill(g, 1);

        int ans = 1;
        int pre = arr[0];
        for(int i = 1; i < n; i++) {
            if(arr[i] > pre) {
                f[i] = g[i - 1] + 1;
            } else if(arr[i] < pre) {
                g[i] = f[i - 1] + 1;
            }
            ans = Math.max(ans, Math.max(f[i], g[i]));
            pre = arr[i];
        }
        return ans;
    }
    public int maxTurbulenceSize1(int[] arr) {
        // a:当前位置元素大于前一个元素的最长湍流子数组长度
        int a = 1, b = 1, ans = 1;
        int n = arr.length;
        int pre = arr[0];
        for(int i = 1; i < n; i++) {
            if(arr[i] > pre) {
                a = b + 1;
                b = 1;
            } else if(arr[i] < pre) {
                b = a + 1;
                a = 1;
            } else {
                a = b = 1;
            }

            ans = Math.max(ans, Math.max(a, b));
            pre = arr[i];
        }
        return ans;
    }
}
