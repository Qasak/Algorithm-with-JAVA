package leetcode.template.Graph.Topology;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/12 9:05
 */
public class Q207_ClassTableI {
    int vis[];
    List<Integer>[] g;
    public boolean canFinish(int k, int[][] pre) {
        vis = new int[k];
        g = new List[k];
        // 建图
        for(int i = 0; i < k; i++) {
            g[i] = new ArrayList<>();
        }
        for(int[] t : pre) {
            g[t[1]].add(t[0]);
        }
        for(int i = 0 ; i < k; i++) {
            if(vis[i] == 0 && !dfs(i)) {
                return false;
            }
        }
        return true;
    }
    boolean dfs(int u) {
        // 正在访问
        vis[u] = 1;
        for(int v : g[u]) {
            // 环
            if(vis[v] == 1) {
                return false;
                // 继续往下访问
            } else if(vis[v] == 0) {
                if(!dfs(v)) {
                    return false;
                }
            }
        }
        // 完成访问(u已经没有出度)
        vis[u] = 2;
        return true;
    }
}
