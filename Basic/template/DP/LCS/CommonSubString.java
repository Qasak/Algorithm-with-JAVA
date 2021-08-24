package leetcode.template.DP.LCS;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/4 17:19
 *
 * 给定两个字符串str1和str2,输出两个字符串的最长公共子串，如果最长公共子串为空，输出-1。
 *LCS
 * "1AB2345CD","12345EF"
 *
 * "2345"
 *      1 A B 2 3 4 5 C D
 * 1    1
 * 2
 * 3
 * 4
 * 5
 * E
 * F
 */
public class CommonSubString {
    public static String commonString(String str1, String str2) {
        if(str1 == null || str2 == null) {
            return "-1";
        }
        int m = str1.length();
        int n = str2.length();
        if(m == 0 || n == 0) {
            return "-1";
        }
        // 记录下“最长公共子串”在str1中的长度
        int idx = 0;
        int maxLen = 0;
        int[][] dp = new int[m + 1][n + 1];
        //dp[i][j]代表 str1长度为i的子串和str2长度为j的子串 的最长公共子串的长度
        // "1AB2345CD","12345EF"
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if(maxLen < dp[i][j]) {
                    maxLen = dp[i][j];
                    idx = i;
                }
            }
        }
        if(maxLen == 0) {
            return "-1";
        }
        return str1.substring(idx - maxLen, idx);
    }


    public static void main(String[] args) {
        String s1 = "1AB2345CD";
        String s2 = "12345EF";
        System.out.println(CommonSubString.commonString(s1, s2));
    }
}
