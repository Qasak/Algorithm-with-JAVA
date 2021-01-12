package leetcode.template.Graph.Topology;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/12 9:06
 */
public class Q210_ClassTableII {
    List<Integer>[] g;
    int[] vis;
    int[] ans;
    int idx;
    public int[] findOrder(int k, int[][] p) {
        g = new List[k];
        vis = new int[k];
        ans = new int[k];
        idx = k - 1;
        for(int i = 0 ; i < k; i++) {
            g[i] = new ArrayList<>();
        }
        for(int[] t : p) {
            g[t[1]].add(t[0]);
        }
        for(int i = 0 ; i < k; i++) {
            if(vis[i] == 0 && !dfs(i)) {
                return new int[]{};
            }
        }
        return ans;
    }
    boolean dfs(int u) {
        vis[u] = 1;
        for(int v : g[u]) {
            // 当前有环
            if(vis[v] == 1) {
                return false;
                // 子图有环
            } else if(vis[v] == 0 && !dfs(v)) {
                return false;
            }
        }
        vis[u] = 2;
        ans[idx--] = u;
        return true;
    }
}
