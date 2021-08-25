class Solution {
    int[][] g;
    List<List<Integer>> ans;
    int n;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        g = new int[n][n];
        ans = new ArrayList<>();
        for(int i = 0 ; i < n; i++) {
            for(int v : graph[i]) {
                g[i][v] = 1;
            }
        }
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, path);
        return ans; 
    }
    void dfs(int u, List<Integer> path) {
        if(u == n - 1) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int v = 0; v < n; v++) {
            if(g[u][v] == 0) {
                continue;
            }
            path.add(v);
            dfs(v, path);
            path.remove(path.size() - 1);
        }
    }
}