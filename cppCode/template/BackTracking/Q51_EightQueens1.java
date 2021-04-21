package leetcode.template.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/23 17:29
 */
public class Q51_EightQueens1 {
    private  List<List<String>> res = new ArrayList<>();
    int n;
    public  List<List<String>> solveNQueens(int n) {
        this.n = n;
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], '.');
        }

        int col, dg, udg;
        col = dg = udg = 0;
        dfs(0, grid, col, dg, udg);
        return res;
    }
    private void dfs(int i, char[][] grid, int col, int dg, int udg) {
        if(i == n) {
            List<String> one = new ArrayList<>();
            for(int k = 0; k < n; k++) {
                one.add(new String(grid[k]));
            }
            res.add(one);
        } else {
            // x&(−x) 可以获得 x 的二进制表示中的最低位的 1 的位置；
            //
            //x&(x−1) 可以将 x 的二进制表示中的最低位的 1 置成 0。

            // 1:能放
            // 0:不能放
            // 每次获得可以放置皇后的位置中的最低位，并将该位的值置成 0，尝试在该位置放置皇后
            for(int p = ((1 << n) - 1) & (~(col | dg | udg)); p != 0; p = p & (p - 1)) {
                int lowbit = p &(-p);
                // 最低位对应drid中的第0列
                int j = Integer.bitCount(lowbit - 1);
                grid[i][j] = 'Q';
                dfs(i + 1, grid, col | lowbit, (dg | lowbit) << 1, (udg | lowbit) >> 1);
                grid[i][j] = '.';
            }
        }
    }
}
