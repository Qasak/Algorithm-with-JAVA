package leetcode.SpringRecruit.DP;

import java.util.TreeSet;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/3 0:01
 */
public class Q1143_最长公共子序列 {
    class Solution {
        public int longestCommonSubsequence(String a, String b) {
            int n = a.length();
            int m = b.length();

            // dp[i][j] : a[0, i) b[0, j)
            int[][] dp = new int[n + 1][m + 1];
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= m; j++) {
                    if(a.charAt(i - 1) == b.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[n][m];
        }
    }

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        System.out.println(set.ceiling(0));
        System.out.println(set.ceiling(1));

        System.out.println(set.ceiling(2));

    }
}
