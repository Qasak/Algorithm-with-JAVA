package leetcode.template.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/17 18:34
 */
public class Q44_通配符匹配 {
    // DFS (超时)
    boolean[][] dp;
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        dp = new boolean[n + 1][m + 1];

        if(n == 0 && m == 0) {
            return true;
        } else if(n > 0 && m == 0) {
            return false;
        } else if(n == 0 && m > 0) {
            if(p.charAt(0) != '*') {
                return false;
            } else {
                return isMatch(s, p.substring(1, m));
            }
        } else {
            char a = s.charAt(0);
            char b = p.charAt(0);
            if(b == '*') {
                for(int i = 0; i <= n; i++) {
                    if(isMatch(s.substring(i, n), p.substring(1, m))) {
                        return true;
                    }
                }
                return false;
            } else {
                if(a == b || b == '?') {
                    return isMatch(s.substring(1, n), p.substring(1, m));
                } else {
                    return false;
                }
            }
        }
    }
    // DP 未优化

    public boolean isMatch1(String s, String p) {
        int n = s.length();
        int m = p.length();
        if(n == 0 && m == 0) {
            return true;
        }
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for(int i = 0; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(i == 0) {
                    if(p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 1];
                    }
                    continue;
                }
                char a = s.charAt(i - 1);
                char b = p.charAt(j - 1);
                if(b == '*') {
                    int t = 0;
                    for(; t <= n; t++) {
                        if(dp[t][j - 1]) {
                            break;
                        }
                    }
                    for(int k = t; k <= i; k++) {
                        dp[i][j] = (dp[i][j] || dp[k][j - 1]);
                    }
                } else {
                    if(a == b || b == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[n][m];
    }
    // DP 优化
    public boolean isMatch2(String s, String p) {
        int n = s.length();
        int m = p.length();
        if(n == 0 && m == 0) {
            return true;
        }
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for(int i = 0; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(i == 0) {
                    // ""
                    // "******"
                    if(p.charAt(j - 1) == '*') {
                        // dp[i][j - 1] : 让*匹配空字符
                        dp[i][j] = dp[i][j - 1];
                    }
                    continue;
                }
                char a = s.charAt(i - 1);
                char b = p.charAt(j - 1);
                if(b == '*') {
                    // dp[i - 1][j] : 让*匹配当前字符
                    // dp[i][j - 1] : 让*匹配空 eg : s="a" p="*a*"
                    // if(dp[i - 1][j]) {
                    //     System.out.println(i + " " + j);
                    //     System.out.println(dp[i - 1][j]);
                    // }
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    if(a == b || b == '?') {
                        // 使用 a 和 b
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[n][m];
    }
}
