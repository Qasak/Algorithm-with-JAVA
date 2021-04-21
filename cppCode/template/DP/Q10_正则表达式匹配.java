package leetcode.template.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/17 18:34
 */
public class Q10_正则表达式匹配 {
    // DFS
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        if(".*".equals(p)) {
            return true;
        }
        if(s.length() == 0 ) {
            if(p.length() == 0) {
                return true;
            } else {
                if(p.length() == 1) {
                    return false;
                } else {
                    if(p.charAt(1) == '*') {
                        return isMatch(s, p.substring(2, m));
                    } else {
                        return false;
                    }
                }
            }
        } else {
            if(p.length() == 0) {
                return false;
            }
        }
        if(p.length() > 2 && ".*".equals(p.substring(0, 2))) {
            for(int i = 0; i <= n; i++) {
                if(isMatch(s.substring(i, n), p.substring(2, m))) {
                    return true;
                }
            }
            return false;
        }
        char a = s.charAt(0);
        char b = p.charAt(0);

        if(p.length() == 1) {
            if(s.length() > 1) {
                return false;
            }
            if(a == b || b == '.') {
                return true;
            } else {
                return false;
            }
        }

        if(a == b) {
            if(p.charAt(1) == '*') {
                int k = 1;
                while(k < n && s.charAt(k) == a) {
                    k++;
                }
                for(int i = 0; i <= k; i++) {
                    if(isMatch(s.substring(i, n), p.substring(2, m))) {
                        return true;
                    }
                }
                return false;
            } else {
                return isMatch(s.substring(1, n), p.substring(1, m));
            }
        } else {
            if(p.charAt(1) == '*') {
                return isMatch(s.substring(0, n), p.substring(2, m));
            } else {
                if(b == '.') {
                    return isMatch(s.substring(1, n), p.substring(1, m));
                } else {
                    return false;
                }
            }
        }
    }


    public boolean isMatch1(String s, String p) {
        if(p.isEmpty()) {
            return s.isEmpty();
        }
        int n = s.length();
        int m = p.length();
        boolean flag = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if(m >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2, m)) || (flag && isMatch(s.substring(1, n), p));
        } else {
            return flag && isMatch(s.substring(1, n), p.substring(1, m));
        }
    }


    // dp
    public boolean isMatch2(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        // s串为空时，有两种情况可匹配：1. p空  2.p[j - 1]为 '*'
        dp[0][0] = true;
        for(int i = 0; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(i == 0) {
                    if(p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 2];
                    }
                    continue;
                }
                char a = s.charAt(i - 1);
                char b = p.charAt(j - 1);
                if(b == '*') {
                    if(a == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                } else {
                    if(a == b || b == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[n][m];
    }
}
