package leetcode.template.DP;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/8 22:22
 */
public class Q132_分割回文串2 {
    public int minCut(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], true);
        }
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                dp[i][j] = cs[i] == cs[j] && dp[i + 1][j - 1];
            }
        }
        int[] dp1 = new int[n];
        Arrays.fill(dp1, Integer.MAX_VALUE);
        for(int i = 0; i < n; i++) {
            if(dp[0][i]) {
                dp1[i] = 0;
            } else {
                for(int j = 0; j < i; j++) {
                    if(dp[j + 1][i]) {
                        dp1[i] = Math.min(dp1[i], dp1[j] + 1);
                    }
                }
            }
        }
        return dp1[n - 1];
    }
}
