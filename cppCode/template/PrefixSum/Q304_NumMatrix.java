package leetcode.template.PrefixSum;

import java.util.TreeSet;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/7 19:54
 */
public class Q304_NumMatrix {
    // 查询O(n)
    class NumMatrix {
        private int[][] g;
        private int[][] pre;
        public NumMatrix(int[][] matrix) {
            g = matrix;
            int n = matrix.length;
            if(n == 0) {
                return;
            }
            int m = matrix[0].length;
            // System.out.println(n +  " " + m);
            pre = new int[n][m + 1];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    pre[i][j + 1] = pre[i][j] + g[i][j];
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

    // 前缀和2: 查询O(1)
    class NumMatrix1 {
        private int[][] g;
        private int[][] pre;
        public NumMatrix1(int[][] matrix) {
            g = matrix;
            int n = matrix.length;
            if(n == 0) {
                return;
            }
            int m = matrix[0].length;
            // System.out.println(n +  " " + m);
            pre = new int[n][m + 1];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    pre[i][j + 1] = pre[i][j] + g[i][j];
                }
            }
            for(int i = 1; i < n; i++) {
                for(int j = 0; j <= m; j++) {
                    pre[i][j] += pre[i - 1][j];
                }
                // System.out.println(Arrays.toString(pre[i]));
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int a,b,c,d;
            a = pre[row2][col2 + 1];
            b = pre[row2][col1];
            c = row1 == 0 ? 0: pre[row1 - 1][col2 + 1];
            d = row1 == 0 ? 0: pre[row1 - 1][col1];
            return a - b - c + d;
        }
    }
    private int[][] dp;

    class NumMatrix2 {
        int[][] pre;
        public NumMatrix2(int[][] matrix) {
            int n = matrix.length;
            if(n == 0) {
                return;
            }
            int m = matrix[0].length;
            pre = new int[n + 1][m + 1];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    pre[i + 1][j + 1] = pre[i][j + 1] + pre[i + 1][j] + matrix[i][j] - pre[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return pre[row2 + 1][col2 + 1] - pre[row2 + 1][col1] - pre[row1][col2 + 1] + pre[row1][col1];
        }
    }
/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(5);
        int a = set.ceiling(3);
        int b = 1 << 31;
        System.out.println(b);
    }
}
