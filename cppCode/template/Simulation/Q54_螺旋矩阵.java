package leetcode.template.Simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/5 11:23
 */
public class Q54_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        if(n == 0) {
            return ans;
        }
        int m = matrix[0].length;
        if(m == 0) {
            return ans;
        }
        int u = 0, d = n - 1, l = 0, r = m - 1;
        int cnt = 0;
        while(cnt < m * n) {
            for(int i = u, j = l; cnt < m * n && j <= r ; j++) {
                ans.add(matrix[i][j]);
                cnt++;
            }
            u++;
            for(int i = u, j = r; cnt < m * n && i <= d; i++) {
                ans.add(matrix[i][j]);
                cnt++;
            }
            r--;
            for(int i = d, j = r; cnt < m * n && j >= l; j--) {
                ans.add(matrix[i][j]);
                cnt++;
            }
            d--;
            for(int i = d, j = l; cnt < m * n && i >= u; i--) {
                ans.add(matrix[i][j]);
                cnt++;
            }
            l++;
        }
        return ans;
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        if(n == 0) {
            return ans;
        }
        int m = matrix[0].length;
        if(m == 0) {
            return ans;
        }
        int u = 0, d = n - 1, l = 0, r = m - 1;
        while(true) {
            for(int i = u, j = l; j <= r ; j++) {
                ans.add(matrix[i][j]);
            }
            if(++u > d) {
                break;
            }
            for(int i = u, j = r; i <= d; i++) {
                ans.add(matrix[i][j]);
            }
            if(--r < l) {
                break;
            }
            for(int i = d, j = r; j >= l; j--) {
                ans.add(matrix[i][j]);
            }
            if(--d < u) {
                break;
            }
            for(int i = d, j = l; i >= u; i--) {
                ans.add(matrix[i][j]);
            }
            if(++l > r) {
                break;
            }
        }
        return ans;
    }

    // DFS
    boolean[][] vis;
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int dir;
    List<Integer> ans;
    int m;
    int n;
    public List<Integer> spiralOrder2(int[][] matrix) {
        dir = 0;
        ans = new ArrayList<>();
        n = matrix.length;
        if(n == 0) {
            return ans;
        }
        m = matrix[0].length;
        if(m == 0) {
            return ans;
        }
        vis = new boolean[n][m];
        dfs(matrix, 0, 0);
        return ans;
    }
    public void dfs(int[][] matrix, int i, int j) {
        if(i < 0 || i >= n || j < 0 || j >= m || vis[i][j]) {
            return;
        }
        ans.add(matrix[i][j]);
        vis[i][j] = true;
        while(ans.size() < m * n) {
            dfs(matrix, i + dirs[dir % 4][0], j + dirs[dir % 4][1]);
            dir++;
        }
    }
}
