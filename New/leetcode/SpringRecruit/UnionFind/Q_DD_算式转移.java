package leetcode.SpringRecruit.UnionFind;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/30 19:03
 */
public class Q_DD_算式转移 {
    public static void main(String[] args) {
        int[] dp = new int[11];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 3; i <= 10; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] +dp[i - 3];
        }
        System.out.println(dp[10]);
    }
}
