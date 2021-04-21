package leetcode.template.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/4 14:54
 */
public class Q712 {

    // 最暴力的dfs
    int ans;
    public int minimumDeleteSum(String s1, String s2) {
        if(s1.equals(s2)) {
            return 0;
        }
        ans = Integer.MAX_VALUE;
        dfs(new StringBuilder(s1), new StringBuilder(s2), 0);
        return ans;

    }
    public void dfs(StringBuilder a, StringBuilder b, int cur) {
        if(a.toString().equals(b.toString())) {
            ans = Math.min(ans, cur);
            return;
        }
        int t = Integer.MAX_VALUE;
        int n = a.length();
        int m = b.length();
        if(n > m) {
            for(int i = 0; i < n; i++) {
                char ch1 = a.charAt(i);
                a.deleteCharAt(i);
                dfs(a, b, cur + ch1);
                a.insert(i, ch1);
            }
        } else if(n < m){
            for(int j = 0; j < m; j++) {
                char ch2 = b.charAt(j);
                b.deleteCharAt(j);
                dfs(a, b, cur + ch2);
                b.insert(j, ch2);
            }
        } else {
            for(int i = 0; i < n; i++) {
                char ch1 = a.charAt(i);
                a.deleteCharAt(i);
                dfs(a, b, cur + ch1);
                for(int j = 0; j < m; j++) {
                    char ch2 = b.charAt(j);
                    b.deleteCharAt(j);
                    dfs(a, b, cur + ch1 + ch2);
                    b.insert(j, ch2);
                }
                a.insert(i, ch1);
            }
        }
    }
    // dp
    public int minimumDeleteSum1(String s1, String s2) {
        int ans = Integer.MAX_VALUE;
        int n = s1.length();
        int m = s2.length();
        // dp[i][j] : s1[i:]  和 s2[j:] 两个子串需要删除的最小和
        // 返回dp[0][0]
        int[][] dp = new int[n + 1][m + 1];
        for(int i = n - 1; i >= 0; i--) {
            dp[i][m] = dp[i + 1][m] + (int)(s1.charAt(i));
        }
        for(int i = m - 1; i >= 0; i--) {
            dp[n][i] = dp[n][i + 1] + (int)(s2.charAt(i));
        }
        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j] + (int)(s1.charAt(i)),
                            dp[i][j + 1] + (int)(s2.charAt(j)));
                }
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        String a = "abcd";
        System.out.println(a.codePointAt(0));
        System.out.println(a.codePointAt(1));

        System.out.println(a.codePointAt(2));

        System.out.println((int)(a.charAt(3)));

    }
}
