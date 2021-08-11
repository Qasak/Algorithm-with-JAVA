package Mitsuha.序列DP;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/11 16:22
 */
public class Q978_最长湍流子数组 {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        // f[i][0] >
        // f[i][1] <
        int[][] f = new int[n][2];
        int ans = 1;
        for(int i = 0; i < n; i++) {
            Arrays.fill(f[i], 1);
        }
        for(int i = 1; i < n; i++) {
            if(arr[i] > arr[i - 1]) {
                f[i][0] = f[i - 1][1] + 1;
            } else if(arr[i] < arr[i - 1]) {
                f[i][1] = f[i - 1][0] + 1;
            }
            ans = Math.max(ans, Math.max(f[i][0], f[i][1]));
        }
        return ans;
    }
}
