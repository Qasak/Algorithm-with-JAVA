package leetcode.contest.Rating1800.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/19 9:51
 */
public class Q1230_抛掷硬币 {
    // 杨辉三角
    public double probabilityOfHeads(double[] prob, int target) {
        double ans = 1;
        int n = prob.length;
        // f[i][j] 前i个硬币j个正面朝上的概率
        double[][] f = new double[n][n + 1];

        f[0][0] = 1 - prob[0];
        f[0][1] = prob[0];
        // j <= i
        for(int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][0] * (1 - prob[i]);
            f[i][i + 1] = f[i - 1][i] * prob[i];
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= i; j++) {
                f[i][j] += f[i - 1][j - 1] * prob[i] + f[i - 1][j] * (1 - prob[i]);
            }
        }

        return f[n - 1][target];
    }
    public static void main(String[] args) {
        System.out.println(Math.pow(0.5, 5));
    }
}
