package leetcode.contest.Rating2000.图.拓扑排序;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/5 11:45
 */
public class Q802_找到最终的安全状态 {
    Set<Integer> safe = new HashSet<>();
    Set<Integer> unSafe = new HashSet<>();
    int[][] g;
    boolean[] vis;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        g = graph;
        vis = new boolean[n];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(dfs(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
    boolean dfs(int i) {
        if(vis[i]) {
            if(safe.contains(i)) {
                return true;
            }
            if(unSafe.contains(i)) {
                return false;
            }
            unSafe.add(i);
            return false;
        }
        vis[i] = true;
        if(g[i].length == 0) {
            safe.add(i);
            return true;
        }
        boolean isSafe = true;
        for(int v : g[i]) {
            isSafe &= dfs(v);
        }
        if(isSafe) {
            safe.add(i);
            return true;
        } else {
            unSafe.add(i);
            return false;
        }
    }
}
