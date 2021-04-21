package leetcode.template.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/18 18:44
 */
public class Q91_解码方法 {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        if(s.charAt(0) == '0') {
            return 0;
        }
        dp[0] = 1;

        for(int i = 0; i < n; i++) {
            if(i == 0) {
                continue;
            }
            if(s.charAt(i) == '0') {
                // 两个连续0 : 无法解码
                if(s.charAt(i - 1) == '0') {
                    dp[i] = 0;
                } else if(Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
                    // 只接受 10 或 20 : 0 不能单独存在，合并成一个数
                    if(i == 1) {
                        dp[i] = 1;
                        continue;
                    }
                    dp[i] = dp[i - 2];
                }
            } else {
                if(s.charAt(i - 1) == '0') {
                    dp[i] = dp[i - 1];
                } else if(Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
                    if(i == 1) {
                        dp[i] = dp[i - 1] + 1;
                        continue;
                    }
                    // 可以作为一个一位数或二位数
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    // 作为一个一位数
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[n - 1];
    }
    public static void main(String[] args) {
        System.out.println(Integer.valueOf("002"));
    }
}
