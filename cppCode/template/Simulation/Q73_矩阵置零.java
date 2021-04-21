package leetcode.template.Simulation;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/21 0:02
 */
public class Q73_矩阵置零 {
    int n;
    int m;
    boolean[][] vis;
    public void setZeroes(int[][] matrix) {
        n = matrix.length;
        if(n == 0) {
            return;
        }
        m = matrix[0].length;
        if(m == 0) {
            return;
        }
        vis = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    if(!vis[i][j]) {
                        set(matrix, i, j);
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(row));
        // System.out.println(Arrays.toString(col));

    }

    public void set(int[][] matrix, int i, int j) {
        for(int k = 0; k < m; k++) {
            if(matrix[i][k] != 0) {
                matrix[i][k] = 0;
                vis[i][k] = true;
            }
        }
        for(int k = 0; k < n; k++) {
            if(matrix[k][j] != 0) {
                matrix[k][j] = 0;
                vis[k][j] = true;
            }
        }
    }


    public void setZeroes1(int[][] matrix) {
        n = matrix.length;
        if(n == 0) {
            return;
        }
        m = matrix[0].length;
        if(m == 0) {
            return;
        }
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(int i : row) {
            setRow(matrix, i);
        }
        for(int j : col) {
            setCol(matrix, j);
        }
    }

    public void setRow(int[][] matrix, int i) {
        for(int k = 0; k < m; k++) {
            matrix[i][k] = 0;
        }
    }
    public void setCol(int[][] matrix, int j) {
        for(int k = 0; k < n; k++) {
            matrix[k][j] = 0;
        }
    }

    // 保存0的行列，扫描两次
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        PriorityQueue<int[]> buy = new PriorityQueue((o1, o2) -> {
            int[] a = (int[]) o1;
            int[] b = (int[]) o2;
            return b[0] - a[0];
        });
    }
}
