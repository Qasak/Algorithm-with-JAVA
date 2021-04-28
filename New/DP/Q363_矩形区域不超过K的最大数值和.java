package leetcode.SpringRecruit.DP;

import java.util.TreeSet;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/22 9:10
 */
public class Q363_矩形区域不超过K的最大数值和 {
    // 1. 暴力
    public int maxSumSubmatrix(int[][] matrix, int k) {
        // 区域和
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] f = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1] + matrix[i - 1][j - 1] - f[i - 1][j - 1];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int x0 = 0; x0 < m; x0++) {
            for(int x1 = x0 + 1; x1 <= m; x1++) {
                int sum = 0;
                int[] dp = new int[n + 1];
                for(int y0 = 0; y0 <= n; y0++) {
                    for(int y1 = y0 + 1; y1 <= n; y1++) {
                        int area = f[x1][y1] - f[x1][y0] - f[x0][y1] + f[x0][y0];
                        if(area <= k) {
                            max = Math.max(max, area);
                        }
                    }
                }
            }
        }
        return max;
    }
    // 2. TreeSet
    class Solution {
        public int maxSumSubmatrix(int[][] matrix, int k) {
            // 区域和
            int m = matrix.length;
            int n = matrix[0].length;
            int max = Integer.MIN_VALUE;
            for(int x0 = 0; x0 < m; x0++) {
                int[] dp = new int[n];
                for(int x1 = x0; x1 < m; x1++) {
                    for(int c = 0; c < n; c++) {
                        dp[c] += matrix[x1][c];
                    }
                    TreeSet<Integer> set = new TreeSet<>();
                    set.add(0);
                    int s = 0;
                    // 参考两数之和
                    for(int v : dp) {
                        s += v;
                        // s = x + y
                        // s = k + y
                        Integer x = set.ceiling(s - k);
                        if(x != null) {
                            max = Math.max(max, s - x);
                        }
                        set.add(s);
                    }
                    // System.out.println(Arrays.toString(dp) + " " + set);
                }
            }
            return max;
        }
    }
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(0);
        set.add(3);
        set.add(4);
        // Returns the greatest element in this set less than or equal to the given element
        // 返回满足小于等于给定元素的元素中的最大元素
        // Returns the least element in this set greater than or equal to the given element, or null if there is no such element.
        System.out.println(set.ceiling(2));
    }
}
