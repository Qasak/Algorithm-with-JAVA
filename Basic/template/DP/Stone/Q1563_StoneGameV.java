package leetcode.template.DP.Stone;

import java.util.Arrays;
//        int ans = 0;
//
//        int p = 0;
//        int lsum = 0;
//        int rsum = 0;
//        // alice得到的值最大：划分的两个数组差值最小
//        // 这是有问题的
//        // 反例：34,29,77,1,2,69
//        while (l  < r) {
//            int diff = Integer.MAX_VALUE;
//            for(int i = l; i < r; i++) {
//                if(diff >= Math.abs(pre[i] - pre[l] - pre[r ] + pre[i])) {
//                    diff = Math.abs(pre[i] - pre[l] - pre[r ] + pre[i]);
//                    p = i;
//                    lsum = pre[i ] - pre[l];
//                    rsum = pre[r ] - pre[i];
//                }
//            }
//            // 左边大，扔掉，取右边
//            if(lsum > rsum) {
//                l = p;
//                ans += rsum;
//            // 右边大，扔掉，取左边
//            } else if(lsum < rsum){
//                r = p;
//                ans += lsum;
//            } else {
//                // 若划分数组相等，则加上一遍的和过后，将左右两边分别划分，取小值加上
//                // TODO
//                // dp 如果两行的值相等，Bob 让 Alice 决定丢弃哪一行
//                // [1,4,2,3]
//                ans += lsum;
//                return ans + Math.max(getMax(l, p), getMax(p, r));
//            }
//        }
//        return ans;
/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/21 22:42
 *
 * 如果两行的值相等，Bob 让 Alice 决定丢弃哪一行
 *
 */
public class Q1563_StoneGameV {
    static int[] pre;
//    static int[][] dp;
    // O(n^3)/ O(n^2)
    public static int stoneGameV(int[] s) {
        int n = s.length;
        int[] preSum = new int[n + 1];
        dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + s[i];
        }
        pre = preSum;
        return getMax(0, n);
    }
    // 返回 [l,r)区间Alice能获取的最大值
    static private int getMax(int l, int r) {
        if(l == r) {
            return 0;
        }
        if(dp[l][r - 1] != 0) {
            return dp[l][r - 1];
        }
        int ans = 0;
        // i = [l, r - 1]
        for(int i = l; i < r; i++) {
            int s1 = pre[i] - pre[l];
            int s2 = pre[r] - pre[i];
            if(s1 < s2) {
                ans = Math.max(ans, s1 + getMax(l, i));
            } else if(s1 > s2) {
                ans = Math.max(ans, s2 + getMax(i, r));
            } else {
                ans = Math.max(ans, s1 + Math.max(getMax(l, i), getMax(i, r)));
            }
        }
        return dp[l][r - 1] = ans;
    }
    // dp
    static int[][] dp;
    static int[][] maxl;
    static int[][] maxr;

    public static int stoneGameV1(int[] s) {
        int n = s.length;
        dp = new int[n][n];
        maxl = new int[n][n];
        maxr = new int[n][n];
        for (int l = n - 1; l >= 0; --l) {
            maxl[l][l] = maxr[l][l] = s[l];
            int sum = s[l], suml = 0;
            for (int r = l + 1, i = l - 1; r < n; ++r) {
                sum += s[r];
                while (i + 1 < r && (suml + s[i + 1]) * 2 <= sum) {
                    suml += s[i + 1];
                    ++i;
                }
                if (l <= i) {
                    dp[l][r] = Math.max(dp[l][r], maxl[l][i]);
                }
                if (i + 1 < r) {
                    dp[l][r] = Math.max(dp[l][r], maxr[i + 2][r]);
                }
                if (suml * 2 == sum) {
                    dp[l][r] = Math.max(dp[l][r], maxr[i + 1][r]);
                }
                maxl[l][r] = Math.max(maxl[l][r - 1], sum + dp[l][r]);
                maxr[l][r] = Math.max(maxr[l + 1][r], sum + dp[l][r]);
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        // 1,4,2,3
        // {1,4} -> 1
        // {2,3} -> 2
        // {1,4,2,3} -> 5 + 2

        // 34,29,77,1,2,69
        // -> 92 = (34 + 29) + 29
        int[] a = new int[]{34,29,77,1,2,69};
        System.out.println(stoneGameV1(a));
    }
}
