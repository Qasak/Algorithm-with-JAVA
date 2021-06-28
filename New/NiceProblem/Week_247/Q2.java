package leetcode.contest.Week_247;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/28 22:05
 */
public class Q2 {
    public static int[][] rotateGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int l = 0, r = m - 1, u = 0, d = n - 1;
        int i = 0, j = 0;
        while(l < r && u < d) {
            int cnt = (r - l + d - u ) * 2;
            int kk = k % cnt;
            while(kk-- > 0) {
                // System.out.println(i + " " + j);
                int t = grid[i][j];
                for(int p = l + 1; p <= r; p++) {
                    grid[u][p - 1] = grid[u][p];
                }
                for(int p = u + 1; p <= d; p++) {
                    grid[p - 1][r] = grid[p][r];
                }

                for(int p = r; p > l; p--) {
                    grid[d][p] = grid[d][p - 1];
                }
                for(int p = d; p > u + 1; p--) {
                    grid[p][l] = grid[p - 1][l];
                }
                grid[i + 1][j] = t;
            }
            l++; r--; u++; d--;
            i++; j++;

        }
        return grid;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{};
    }
}
