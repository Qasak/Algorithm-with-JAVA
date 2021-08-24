package leetcode.template.PrefixSum;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/2 15:33
 */

// 积分图（总和面积表）是一个快速且有效的对一个网格的矩形子区域中计算和的数据结构和算法。
public class Q304_renew {
    // 一维前缀和
    class NumMatrix {
        int[][] pre;
        public NumMatrix(int[][] matrix) {
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            int n = matrix.length;
            int m = matrix[0].length;
            pre = new int[n][m + 1];
            for(int i = 0; i < n; i++) {

                for(int j = 0; j < m; j++) {
                    pre[i][j + 1] = pre[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int ans = 0;
            for(int i = row1; i <= row2; i++) {
                ans += pre[i][col2 + 1] - pre[i][col1];
            }
            return ans;
        }
    }
    // 二维前缀和
    class NumMatrix1 {
        int[][] pre;
        public NumMatrix1(int[][] matrix) {
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            int n = matrix.length;
            int m = matrix[0].length;
            pre = new int[n + 1][m + 1];
            for(int i = 0; i < n; i++) {

                for(int j = 0; j < m; j++) {
                    pre[i + 1][j + 1] = pre[i + 1][j] + pre[i][j + 1] - pre[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return pre[row2 + 1][col2 + 1] - pre[row1][col2 + 1] - pre[row2 + 1][col1] + pre[row1][col1];
        }
    }
}
