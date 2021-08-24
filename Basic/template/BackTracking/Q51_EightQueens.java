package leetcode.template.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/8 15:03
 *  输入：4
 *  输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 *  解释: 4 皇后问题存在如下两个不同的解法。
 * [
 * [".Q..", // 解法 1
 *  "...Q",
 *  "Q...",
 *  "..Q."],
 *
 * ["..Q.", // 解法 2
 *  "Q...",
 *  "...Q",
 *  ".Q.."]
 * ]
 *
 */
public class Q51_EightQueens {
    private static List<List<String>> res = new ArrayList<>();
    public static List<List<String>> solveNQueens(int n) {
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], '.');
        }

        boolean[] col = new boolean[n];
        boolean[] dg = new boolean[n + n];
        boolean[] udg = new boolean[n + n];
        dfs(0, n, grid, col, dg, udg);
        return res;
    }

    private static void dfs(int i, int n, char[][] grid, boolean[] col, boolean[] dg, boolean[] udg) {
        // 当前行==n: 填写答案
        if(i == n) {
            List<String> one = new ArrayList<>();
            for(int k = 0; k < n; k++) {
                one.add(new String(grid[k]));
            }
            res.add(one);
        } else {
            for(int j = 0; j < n; j++) {
                // 不行的方法是走不到最后一行的
                if(!col[j] && !dg[n + i - j] && !udg[i + j]) {
                    grid[i][j] = 'Q';
                    col[j] = dg[n + i - j] = udg[i + j] = true;
                    dfs(i + 1, n, grid, col, dg, udg);
                    grid[i][j] = '.';
                    col[j] = dg[n + i - j] = udg[i + j] = false;
                }
            }
        }
        // 对于当前行，判断列值与对角线，并填写在grid中
    }

    public static void main(String[] args) {
        int n = 0;
        Scanner scan = new Scanner(System.in);
        if(scan.hasNextLine()) {
            n = Integer.parseInt(scan.nextLine());
        }
        scan.close();
        solveNQueens(n);
//        for(List<String> l : res) {
//            for(String s : l) {
//                System.out.println(s);
//            }
//            System.out.println("----");
//        }
        System.out.println(res.size());
    }
}
