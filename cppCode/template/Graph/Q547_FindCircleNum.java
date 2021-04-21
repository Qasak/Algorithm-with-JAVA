package leetcode.template.Graph;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/6 14:48
 */
public class Q547_FindCircleNum {
    int[] uf;
    private int find(int x) {
        if(uf[x] == x) {
            return x;
        }
        return uf[x] = find(uf[x]);
    }
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        uf[px] = py;
    }
    public int findCircleNum(int[][] g) {
        int n = g.length;
        uf = new int[n];
        for(int i = 0; i < n; i++) {
            uf[i] = i;
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(g[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(uf[i] == i) {
                cnt++;
            }
        }
        return cnt;
    }
}
