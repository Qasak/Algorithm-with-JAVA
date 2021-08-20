package Mitsuha.路径DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/15 1:16
 */
public class Q576_出界的路径数 {
    int mod = (int) 1e9 + 7;
    int N;
    int M;
    int[][][] f;
    int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        N = m;
        M = n;
        f = new int[N][M][maxMove + 1];
        return dfs(startRow, startColumn, 0, maxMove);
    }
    int dfs(int i, int j, int cur, int maxMove) {
        if(cur > maxMove) {
            return 0;
        }
        if(i < 0 || i >= N || j < 0 || j >= M) {
            return 1;
        }
        int k = maxMove - cur;
        // 剪枝
        if(i > k && N - i > k && j > k && M - j > k) {
            return 0;
        }
        if(f[i][j][cur] != 0) {
            return f[i][j][cur];
        }
        int ret = 0;
        for(int[] d : dir) {
            int xx = i + d[0];
            int yy = j + d[1];
            ret += dfs(xx, yy, cur + 1, maxMove);
            ret %= mod;
        }
        return f[i][j][cur] = ret;
    }
}
