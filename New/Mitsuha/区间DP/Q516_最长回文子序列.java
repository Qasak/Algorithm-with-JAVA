package Mitsuha.区间DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/12 12:33
 */
public class Q516_最长回文子序列 {
    // 转换为LCS
    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int n = cs.length;
        int[][] f = new int[n + 1][n + 1];
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if(cs[i - 1] == ct[j - 1]) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }
        return f[n][n];
    }
}
