package leetcode.contest.NiceProblem.路径DP;

import java.util.Arrays;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/14 11:59
 */
public class Q120_三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(f[i], 0x3f3f3f3f);
        }
        f[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0) {
                    f[i][j] = f[i - 1][j] + triangle.get(i).get(j);
                } else {
                    f[i][j] = Math.min(f[i - 1][j], f[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        return Arrays.stream(f[n - 1]).min().getAsInt();
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] f = new int[n];
        Arrays.fill(f, 0x3f3f3f3f);
        f[0] = triangle.get(0).get(0);
        for(int i = 1; i < n; i++) {
            for(int j = i; j >= 0; j--) {
                if(j == 0) {
                    f[j] = f[j] + triangle.get(i).get(j);
                } else {
                    f[j] = Math.min(f[j], f[j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        return Arrays.stream(f).min().getAsInt();
    }
}
