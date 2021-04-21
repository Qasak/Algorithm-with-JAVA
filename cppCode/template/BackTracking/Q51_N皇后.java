package leetcode.template.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/16 10:18
 */
public class Q51_N皇后 {
    List<List<String>> ans;
    boolean[] col;
    boolean[] ps;
    boolean[] ng;
    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        ps = new boolean[2 * n - 1];
        ng = new boolean[2 * n - 1];
        ans = new ArrayList<>();
        dfs(0, new ArrayList<>());
        return ans;
    }
    public void dfs(int i, List<String> path) {
        int n = col.length;
        if(i == n) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int j = 0; j < n; j++) {
            if(col[j] || ps[n - 1 + j - i] || ng[j + i]) {
                continue;
            }
            col[j] = ps[n - 1 + j - i] = ng[j + i] = true;
            StringBuilder tmp = new StringBuilder();
            for(int k = 0; k < n; k++) {
                if(k == j) {
                    tmp.append("Q");
                } else {
                    tmp.append(".");
                }
            }
            path.add(tmp.toString());
            dfs(i + 1, path);
            path.remove(path.size() - 1);
            col[j] = ps[n - 1 + j - i] = ng[j + i] = false;
        }
    }
}
