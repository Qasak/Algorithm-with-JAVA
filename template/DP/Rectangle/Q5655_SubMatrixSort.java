package leetcode.template.DP.Rectangle;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/17 13:18
 */
public class Q5655_SubMatrixSort {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                matrix[i][j] = (matrix[i][j] == 0 ? 0 : matrix[i - 1][j] + 1);
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            Arrays.sort(matrix[i]);
            int h = matrix[i][m - 1];
            for(int j = m - 1; j >= 0; j--) {
                h = Math.min(h, matrix[i][j]);
                ans = Math.max(ans, h * (m - j));
            }
        }
        return ans;
    }
}
