package leetcode.template.DP.LCS;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/4 21:22
 * 最长公共子序列
 */
public class CommonSubSequence {
    public static String commonSeq(String str1, String str2) {
        if(str1 == null || str2 == null) {
            return "-1";
        }
        int m = str1.length();
        int n = str2.length();
        if(m == 0 || n == 0) {
            return "-1";
        }
        int[][] dp = new int[m + 1][n + 1];
        int[][] path = new int[m + 1][n + 1];
        //dp[i][j]代表 str1长度为i的子串和str2长度为j的子串 的最长公共子序列的长度
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                // 长度 -> 下标
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 如果只算长度
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    // 选择从左边过来的路径
                    if(dp[i - 1][j] < dp[i][j - 1]) {
                        dp[i][j] = dp[i][j - 1];
                        path[i][j]--;
                    } else {
                        // 选择从上边过来的路径
                        dp[i][j] = dp[i - 1][j];
                        path[i][j]++;
                    }
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        trackt(path, str1, sb, m, n);
        return sb.toString();

    }
    // 从末尾开始回溯
    // 到达起点时返回
    private static void trackt(int[][] path, String a, StringBuilder sb, int i, int j) {
        if(i == 0 || j == 0) {
            return;
        }
        if(path[i][j] == 0) {
            trackt(path, a, sb, i - 1, j - 1);
            sb.append(a.charAt(i - 1));
        } else if(path[i][j] == 1) {
            trackt(path, a, sb, i - 1, j);
        } else {
            trackt(path, a, sb, i, j - 1);
        }
    }
    public static void main(String[] args) {
        String s1 = "1AB2345CD";
        String s2 = "12345EF";
        System.out.println(CommonSubSequence.commonSeq(s1, s2));
    }
}
