package leetcode.template.BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/16 10:30
 */
public class Q37_解数独 {
    Set[] row = new Set[9];
    Set[] col = new Set[9];
    Set[][] blk = new Set[3][3];
    public void solveSudoku(char[][] board) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                blk[i][j] = new HashSet<Integer>();
            }
        }
        for(int i = 0; i < 9; i++) {
            row[i] = new HashSet<Integer>();
            col[i] = new HashSet<Integer>();
        }
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';
                row[i].add(num);
                col[j].add(num);
                blk[i / 3][j / 3].add(num);
            }
        }
        dfs(board, 0, 0);
        return;
    }
    public boolean dfs(char[][] board, int i, int j) {
        if(i == 9) {
            return true;
        }
        if(j == 9) {
            return dfs(board, i + 1, 0);
        }
        if(board[i][j] != '.') {
            return dfs(board, i, j + 1);
        }
        for(int k = 1; k <= 9; k++) {
            if(row[i].contains(k) || col[j].contains(k) || blk[i / 3][j / 3].contains(k)) {
                continue;
            }
            board[i][j] = (char) (k + '0');
            row[i].add(k); col[j].add(k); blk[i / 3][j / 3].add(k);
            if(dfs(board, i, j + 1)) {
                return true;
            }
            row[i].remove(k); col[j].remove(k); blk[i / 3][j / 3].remove(k);
            board[i][j] = '.';
        }
        return false;
    }
}
