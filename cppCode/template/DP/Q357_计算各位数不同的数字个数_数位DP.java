package leetcode.template.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/20 0:43
 */
public class Q357_计算各位数不同的数字个数_数位DP {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            int t = 9;
            int base = 9;
            for(int j = 0; j < i - 1; j++) {
                t = t * (base - j);
            }
            dp[i] = t + dp[i - 1];
        }
        return dp[n];
    }
}
