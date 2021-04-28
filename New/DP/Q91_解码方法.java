package leetcode.SpringRecruit.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/21 10:47
 */
public class Q91_解码方法 {
    public int numDecodings(String s) {
        char[] cs = s.toCharArray();

        int n = cs.length;
        if(cs[0] == '0') {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[0] = 1;

        for(int i = 2; i <= n; i++) {
            // 当前元素是0：不能作为单词的开头，必须和之前的元素结合
            // 若之前的元素大于2 或 是0，则不能解码
            if(cs[i - 1] == '0') {
                if(cs[i - 2] == '0' || cs[i - 2] > '2') {
                    return 0;
                } else {
                    dp[i] = dp[i - 2];
                }
            } else {
                // 当前元素是[1, 9] 如果前一个元素是0 或 > 2， 必须单开
                // 如果前一个元素为1 可以结合，也可以单开
                // 如果前一个元素为2 讨论当前值
                // 大于2 ， 必须单开
                if(cs[i - 2] == '0' || cs[i - 2] > '2') {
                    dp[i] = dp[i - 1];
                } else {
                    if(cs[i - 2] == '1') {
                        dp[i] = dp[i - 2] + dp[i - 1];
                    } else if(cs[i - 2] == '2') {
                        dp[i] = cs[i - 1] <= '6' ? dp[i - 2] + dp[i - 1] : dp[i - 1];
                    } else {
                        dp[i] = dp[i - 1];
                    }
                }

            }
        }
        return dp[n];
    }
    // 官方DP
    public int numDecodings1(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] f = new int[n + 1];
        f[0] = 1;
        // 使用一个字符解码
        // 使用两个字符解码
        for(int i = 1; i <= n; i++) {
            if(cs[i - 1] != '0') {
                f[i] += f[i - 1];
            }
            if(i > 1 && cs[i - 2] != '0' && ((cs[i - 2] - '0' ) * 10 + (cs[i - 1] - '0')) <= 26 ) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }
    // 记忆化

}
