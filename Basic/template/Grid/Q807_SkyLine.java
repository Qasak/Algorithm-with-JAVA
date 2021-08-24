package leetcode.template.Grid;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/31 17:29
 */
public class Q807_SkyLine {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        if(n == 0) {
            return 0;
        }
        int m = grid[0].length;
        if(m == 0) {
            return 0;
        }
        int[] line = new int[n];
        int[] vert = new int[m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                line[i] = Math.max(line[i], grid[i][j]);
                vert[j] = Math.max(vert[j], grid[i][j]);
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ans += Math.min(line[i], vert[j]) - grid[i][j];
            }
        }
        return ans;
    }
}
