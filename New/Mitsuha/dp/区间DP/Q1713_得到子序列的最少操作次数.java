package Mitsuha.区间DP;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/12 15:58
 */
public class Q1713_得到子序列的最少操作次数 {
    // 答案 = n - LCS
    // LCS 超内存
    public int minOperations(int[] target, int[] arr) {
        int n = target.length;
        return n - LCS(target, arr);
    }

    int LCS(int[] s1, int[] s2) {
        int n = s1.length;
        int m = s2.length;
        int ans = 0;
        int[][] f = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(s1[i] == s2[j]) {
                    f[i + 1][j + 1] = f[i][j] + 1;
                } else {
                    f[i + 1][j + 1] = Math.max(f[i][j + 1], f[i + 1][j]);
                }
            }
        }
        return f[n][m];
    }

    // target值因为互不相同，所以target下标和值可以一一对应
    // 答案 = n - arr中的LIS
    // 忽略target中不存在的元素

    public int minOperations1(int[] target, int[] arr) {
        int n = target.length;
        Map<Integer, Integer> map = new HashMap<>();
        // target[i] : idx
        for(int i = 0; i < n; i++) {
            map.put(target[i], i);
        }
        int[] f = new int[n + 1];
        f[0] = -1;
        int len = 0;
        for(int i = 0; i < arr.length; i++) {
            if(!map.containsKey(arr[i])) {
                continue;
            }
            int cur = map.get(arr[i]);
            if(cur > f[len]) {
                f[++len] = cur;
            } else {
                // 找到大于等于cur的最小值，覆盖
                // int l = 1, r = len + 1;
                // while(l < r) {
                //     int m = (l + r) >>> 1;
                //     if(f[m] < cur) {
                //         l = m + 1;
                //     } else {
                //         r = m;
                //     }
                // }
                // f[l] = cur;

                // 找到小于cur的最大值，覆盖下一个
                int l = 0, r = len;
                while(l < r) {
                    int m = (l + r + 1) >>> 1;
                    if(f[m] >= cur) {
                        r = m - 1;
                    } else {
                        l = m;
                    }
                }
                f[l + 1] = cur;
            }
            // System.out.println(Arrays.toString(f));
        }
        return n - len;
    }
}
