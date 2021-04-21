package leetcode.JianZhi;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/12 21:15
 */
public class Q12 {
    int[][] dir;
    boolean[][] vis;
    int n;
    int m;
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        vis = new boolean[n][m];
        dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        char[] cs = word.toCharArray();
        for(int i = 0; i < n; i++) {
            for(int j  = 0; j < m; j++) {
                if(board[i][j] == cs[0]) {
                    if(dfs(board, i, j, cs, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }
    private boolean dfs(char[][] board, int i, int j, char[] cs, int idx) {
        if(idx == cs.length - 1) {
            return true;
        }

        vis[i][j] = true;
        for(int[] t: dir) {
            int xx = i + t[0], yy = j + t[1];
            if(xx >= 0 && xx < n && yy >= 0 && yy < m && !vis[xx][yy]
                    && idx < cs.length - 1 && board[xx][yy] == cs[idx + 1]) {
                if(dfs(board, xx, yy, cs, idx + 1)){
                    return true;
                }
            }
        }
        // 一定要加上
        vis[i][j] = false;
        return false;
    }
}
