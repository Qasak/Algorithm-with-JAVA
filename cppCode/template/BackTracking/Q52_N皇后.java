package leetcode.template.BackTracking;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/16 10:15
 */
public class Q52_N皇后 {
    boolean[] col;
    boolean[] ps;
    boolean[] ng;
    int ans = 0;
    public int totalNQueens(int n) {
        col = new boolean[n];
        ps = new boolean[2 * n];
        ng = new boolean[2 * n];
        dfs(0);
        return ans;
    }
    public void dfs(int i) {
        int n = col.length;
        if(i == n) {
            ans++;
            return;
        }
        for(int j = 0; j < n; j++) {
            if(col[j] || ps[n + j - i] || ng[i + j]) {
                continue;
            }
            col[j] = ps[n + j - i] = ng[i + j] = true;
            dfs(i + 1);
            col[j] = ps[n + j - i] = ng[i + j] = false;
        }
    }
}
