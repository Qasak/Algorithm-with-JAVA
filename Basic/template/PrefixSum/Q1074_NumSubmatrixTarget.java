package leetcode.template.PrefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/8 16:22
 */
public class Q1074_NumSubmatrixTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        if(matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int count = 0;
        int i, j, k;
        for(i = 0; i < m; i++) {
            int[] sum = new int[n];
            for(j = i; j < m; j++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int s = 0;
                for(k = 0; k < n; k++) {
                    sum[k] += matrix[j][k];
                    s += sum[k];
                    count += map.getOrDefault(s - target, 0);
                    map.put(s, map.getOrDefault(s, 0) + 1);
                }
            }
        }
        return count;
    }
    public int numSubmatrixSumTarget1(int[][] matrix, int target) {
        int n = matrix.length;
        if(n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        // pre[i][j] : i行j列的竖条的值
        int[][] pre = new int[n][m];
        // 固定某一列，求其前缀行和
        for(int j = 0; j < m; j++) {
            int sum = 0;
            for(int i = 0; i < n; i++) {
                sum += matrix[i][j];
                pre[i][j] = sum;
            }
        }
        int ans = 0;
        // 枚举上下边界,问题变为和为k的子数组个数
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum = 0;
                for(int k = 0; k < m; k++) {
                    sum += pre[j][k] - (i == 0 ? 0 : pre[i - 1][k]);
                    // System.out.println(i + " "+ sum + " " + pre[j][k + 1]);
                    ans += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }

            }

        }
        return ans;
    }
}
