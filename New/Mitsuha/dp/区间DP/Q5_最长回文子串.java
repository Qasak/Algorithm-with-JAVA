package Mitsuha.区间DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/12 12:22
 */
public class Q5_最长回文子串 {
    // dp
    public String longestPalindrome(String s) {
        char[] cs = s.toCharArray();
        // f[i][j] 区间是否为回文串
        int n = cs.length;
        boolean[][] f = new boolean[n][n];
        for(int i = 0 ; i < n; i++) {
            f[i][i] = true;
        }
        int ans = 1;
        int l = 0, r = 0;
        for(int len = 0; len < n; len++) {
            // [i, j)
            for(int i = 0; i + len < n; i++) {
                int j = i + len;
                if(len <= 1) {
                    f[i][j] = cs[i] == cs[j];
                } else {
                    f[i][j] = f[i + 1][j - 1] && cs[i] == cs[j];
                }
                if(f[i][j]) {
                    int cur = j - i + 1;
                    if(cur > ans) {
                        l = i; r = j;
                    }
                }
            }
        }
        return s.substring(l, r + 1);
    }

    // 马拉车

}
