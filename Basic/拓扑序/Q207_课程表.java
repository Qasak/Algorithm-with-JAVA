class Solution {
    int[] vis;
    Map<Integer, List<Integer>> g;
    boolean[] f;
    public boolean canFinish(int n, int[][] prerequisites) {
        g = new HashMap<>();
        vis = new int[n];   
        f = new boolean[n];
        for(int[] e : prerequisites) {
            int u = e[0], v = e[1];
            g.putIfAbsent(u, new ArrayList<>());
            g.get(u).add(v);
        }
        for(int i = 0; i < n; i++) {
            if(!dfs(i)) {
                return false;
            }
        }
        return true;
    }
    boolean dfs(int u) {
        if(vis[u] == 1) {
            return false;
        }
        if(f[u]) {
            return true;
        }
        List<Integer> list = g.get(u);
        if(list == null) {
            return true;
        }
        vis[u] = 1;
        for(int v : list) {
            if(!dfs(v)) {
                return false;
            }
        }
        vis[u] = 0;
        return f[u] = true;
    }
}