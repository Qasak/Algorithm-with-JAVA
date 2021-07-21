package leetcode.contest.Ranking2200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/21 10:02
 */
public class Q1889_装包裹的最小浪费空间 {
    // 暴力二分：超时
    int mod = (int) ( 1e9 + 7);
    public int minWastedSpace(int[] packages, int[][] boxes) {
        int max = Arrays.stream(packages).max().getAsInt();
        Arrays.sort(packages);
        List<int[]> cap = new ArrayList<>();
        for(int[] t : boxes) {
            int mx = Arrays.stream(t).max().getAsInt();
            if(mx >= max) {
                Arrays.sort(t);
                cap.add(t);
            }
        }
        if(cap.size() == 0) {
            return -1;
        }
        int n = packages.length;
        long ans = Long.MAX_VALUE;
        for(int[] t : cap) {
            long min = 0;
            for(int i = 0; i < n; i++) {
                int l = 0, r = t.length - 1;
                while(l < r) {
                    int m = (l + r) >>> 1;
                    if(t[m] < packages[i]) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
                min += t[l] - packages[i];
                min %= mod;
            }
            ans = Math.min(ans, min);
        }
        return (int) (ans % mod);
    }

    // 逆向思维：箱子找包裹，前缀和一次算出差值
    public int minWastedSpace1(int[] packages, int[][] boxes) {
        int max = Arrays.stream(packages).max().getAsInt();
        Arrays.sort(packages);
        int n = packages.length;
        long[] pre = new long[n + 1];
        for(int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + packages[i];
        }
        List<int[]> cap = new ArrayList<>();
        for(int[] t : boxes) {
            int mx = Arrays.stream(t).max().getAsInt();
            if(mx >= max) {
                Arrays.sort(t);
                cap.add(t);
            }
        }
        if(cap.size() == 0) {
            return -1;
        }
        long ans = Long.MAX_VALUE;
        for(int[] t : cap) {
            long min = 0;
            int l = 0;
            int p = l;
            for(int i : t) {
                int r = n - 1;
                while(l < r) {
                    int m = (l + r + 1) >>> 1;
                    if(packages[m] > i) {
                        r = m - 1;
                    } else {
                        l = m;
                    }
                }
                if(l == 0 && i < packages[l]) {
                    continue;
                }
                // System.out.println(l);
                // package[l] : 小于等于箱子的最大物品
                min += (( (l - p + 1) * (long)i) - ((pre[l + 1] - pre[p]) ));
                // System.out.println(packages[l] + " " + i + " " + ((l - p + 1) * i) );
                // min = min % mod;
                // min %= mod;
                p = l + 1;
            }
            ans = Math.min(ans, min);
        }
        return (int) (ans % mod);
    }
}
