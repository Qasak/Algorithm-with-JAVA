package leetcode.contest.Rating1800.DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/19 9:51
 */
public class Q1230_抛掷硬币 {
    // 杨辉三角
    public static double probabilityOfHeads(double[] prob, int target) {
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
        System.out.println(Arrays.toString(f[n - 1]));
        return f[n - 1][target];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        double[] nums = new double[n];
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextDouble();
        }
        System.out.println(probabilityOfHeads(nums, target));
    }
}
