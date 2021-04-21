package leetcode.template.String;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/19 23:36
 */
public class Q5_LongestPalindrome {
    // 方法1： DP
    public String longestPalindrome(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        boolean[][] dp = new boolean[n + 1][n + 1];
        int max = 1;
        int pos = 0;
        for(int len = 0; len < n; len++) {
            for(int i = 0; i + len < n; i++) {
                int j = i + len;
                if(len == 0) {
                    dp[i][j] = true;
                } else if(len == 1) {
                    dp[i][j] = (cs[i] == cs[j]);
                } else {
                    dp[i][j] = (dp[i + 1][j - 1] && (cs[i] == cs[j]));
                }
                if(dp[i][j] && len + 1 > max) {
                    max = len + 1;
                    pos = i;
                }
            }
        }
        return s.substring(pos, pos + max);
    }
    // 方法2 中心扩展

    // 方法3 manacher


}
