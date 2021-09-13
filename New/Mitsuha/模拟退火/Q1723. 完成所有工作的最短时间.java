// DFS 超时
class Solution {
    int ans = 0x3f3f3f3f;
    int n;
    int[] jobss;
    int K;
    public int minimumTimeRequired(int[] jobs, int k) {
        int[] time = new int[k];
        jobss = jobs;
        n = jobs.length;
        K = k;
        dfs(0, time, 0);
        return ans;
    }
    // cur : 当前最大工作时间
    public void dfs(int idx, int[] time, int cur) {
        if(cur >= ans) {
            return;
        }
        if(idx == n) {
            ans = Math.min(ans, cur);
            return;
        }
        // 当前工作可以分配给哪个工人
        for(int i = 0; i < K; i++) {
            time[i] += jobss[idx];
            dfs(idx + 1, time, Math.max(cur, time[i]));
            time[i] -= jobss[idx];
        }
    }
}