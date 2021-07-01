package leetcode.contest.NiceProblem.回溯技巧;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/1 11:51
 */

// 对于边权相等的图，统计有限步数的到达某个节点的方案数，最常见的方式是使用 BFS 或 DFS
public class QLCP07_传递信息 {
    // dfs
    private int ans = 0;
    public int numWays(int n, int[][] relation, int k) {
        int len = relation.length;
        for(int i = 0; i < len; i++) {
            if(relation[i][0] == 0) {
                dfs(relation, i, n, k - 1);
            }
        }
        return ans;
    }
    public void dfs(int[][] relation, int i, int n, int k) {
        if(k == 0) {
            if(relation[i][1] == n - 1) {
                ans++;
            }
            return;
        }
        for(int j = 0; j < relation.length; j++) {
            if(relation[j][0] == relation[i][1]) {
                dfs(relation, j, n, k - 1);
            }
        }
    }
    // BFS

    public int numWays1(int n, int[][] relation, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] rel : relation) {
            if(map.get(rel[0]) == null) {
                map.put(rel[0], new ArrayList<>());
            }
            map.get(rel[0]).add(rel[1]);
        }
        Deque<Integer> q = new LinkedList<>();
        q.offer(0);
        while(!q.isEmpty() && k-- > 0) {
            int m = q.size();
            while(m-- > 0) {
                int u = q.poll();
                List<Integer> list = map.get(u);
                if(list == null) {
                    continue;
                }
                for(int v : list) {
                    q.offer(v);
                }
            }
        }
        if(k != -1) {
            return 0;
        }
        // System.out.println(k);
        int ans = 0;
        while(!q.isEmpty()) {
            int u = q.poll();
            if(u == n - 1) {
                ans++;
            }
        }
        return ans;
    }

    // dfs2
    public Map<Integer, List<Integer>> map = new HashMap<>();
    public int numWays2(int n, int[][] relation, int k) {
        for(int[] rel : relation) {
            if(null == map.get(rel[0])) {
                map.put(rel[0], new ArrayList<>());
            }
            map.get(rel[0]).add(rel[1]);
        }
        dfs1(k, 0, n);
        return ans;
    }
    private void dfs1(int k, int u, int n) {
        if(k == 0) {
            if(u == n - 1) {
                ans++;
            }
            return;
        }
        List<Integer> list = map.get(u);
        if(list == null) {
            return;
        }
        for(int v : list) {
            dfs1(k - 1, v, n);
        }
    }

    // dp
    public int numWays3(int n, int[][] relation, int k) {
        int[][] f = new int[k + 1][n];
        f[0][0] = 1;
        for(int i = 1; i <= k; i++) {
            for(int[] rel : relation) {
                int u = rel[0], v = rel[1];
                f[i][v] += f[i - 1][u];
            }
        }
        return f[k][n - 1];
    }
}
