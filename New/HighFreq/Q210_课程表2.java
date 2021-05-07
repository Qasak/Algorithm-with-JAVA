package leetcode.HighFreq;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/26 17:30
 */
public class Q210_课程表2 {
    // 1. DFS
    class Solution {
        private int idx;
        private int[] vis;
        private List<List<Integer>> g;
        private int[] ans;
        // 当图有环时 返回false;
        // // TODO: 如何判断图中是否有环 ?
        private boolean dfs(int u) {
            // System.out.print(u + " ");
            vis[u] = 1;
            for(int v : g.get(u)) {
                if(vis[v] == 2) {
                    continue;
                }
                if(vis[v] == 1) {
                    return false;
                }
                if(vis[v] == 0) {
                    if(!dfs(v)) {
                        return false;
                    }
                }
            }
            vis[u] = 2;
            ans[idx--] = u;
            return true;
        }
        public int[] findOrder(int n, int[][] prerequisites) {
            g = new ArrayList<>();
            ans = new int[n];
            idx = n - 1;
            vis = new int[n];
            if(prerequisites.length == 0) {
                for(int i = 0; i < n; i++) {
                    ans[i] = i;
                }
                return ans;
            }
            for(int i = n; i >= 0; i--) {
                g.add(new ArrayList<Integer>());
            }
            for(int[] t : prerequisites) {
                g.get(t[1]).add(t[0]);
            }
            // 只会往下面走 所以 不用管入度的事情
            for(int i = n - 1; i >= 0; i--) {
                if(vis[i] == 0) {
                    if(!dfs(i)) {
                        return new int[]{};
                    }
                }
            }
            return ans;
        }
    }
    // 2 BFS
}
