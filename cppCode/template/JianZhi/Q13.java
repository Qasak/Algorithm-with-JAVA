package leetcode.JianZhi;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/12 21:43
 */
public class Q13 {
    boolean[][] vis;
    int cnt;
    int[][] dir;
    int N;
    int M;
    public int movingCount(int n, int m, int k) {

        N = n;
        M = m;
        cnt = 0;
        vis = new boolean[n][m];
        dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        dfs(0, 0, k);
        return cnt;
    }
    private void dfs(int i, int j, int k) {
        int x = i, y = j, d = 0;
        while(x > 0) {
            d += x % 10;
            x /= 10;
        }
        while(y > 0) {
            d += y % 10;
            y /= 10;
        }
        if(d > k) {
            return ;
        }
        vis[i][j] = true;
        cnt++;
        for(int [] t : dir) {
            int xx = i + t[0];
            int yy = j + t[1];
            if(xx >= 0 && xx < N && yy >= 0 && yy < M && !vis[xx][yy]) {
                dfs(xx, yy, k);
            }
        }
    }
}
