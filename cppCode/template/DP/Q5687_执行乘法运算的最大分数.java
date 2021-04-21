package leetcode.template.DP;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/21 12:23
 */
public class Q5687_执行乘法运算的最大分数 {
    // 考虑当前已经从nums左边取了L个数，从右边取了R个数，则对于第L+R+1个数，multipliers[L+R+1]（这里下标从1开始）的取值是确定的
    //而在nums中，我们可以选择nums[L+1]或nums[N-R-1]。由于这里无论我们选择左边还是右边，都与前面的L+R次选择无关，满足无后效性的要求，所以我们可以考虑进行动态规划，用dp[L][R]表示左边取L个，右边取R个数时的最大分数。
    public int maximumScore(int[] nums, int[] mul) {
        int m = mul.length;
        int n = nums.length;
        int[][] dp = new int[m + 1][m + 1];
        for(int[] d : dp) {
            Arrays.fill(d, Integer.MIN_VALUE);
        }
        dp[0][0] = 0;
        for (int l = 0; l < m; ++l) {
            for (int r = 0; l + r < m; ++r) {
                dp[l + 1][r] = Math.max(dp[l + 1][r], dp[l][r] + mul[l + r] * nums[l]);
                dp[l][r + 1] = Math.max(dp[l][r + 1], dp[l][r] + mul[l + r] * nums[n - 1 - r]);
            }
        }
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i <= m; ++i) {
            ret = Math.max(ret, dp[i][m - i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        String s = " xx ";
        s = s.trim();
    }
}
