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

// 我们可以重新审视一下这道题。

// 题目其实是让我们将 n个数分为 k 份，并且尽可能让 k 份平均。这样的「最大工作时间」才是最小的。

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
        dfs(0, 0, time, 0);
        return ans;
    }
    // cur : 当前最大工作时间
    public void dfs(int idx, int used, int[] time, int cur) {
        if(cur >= ans) {
            return;
        }
        if(idx == n) {
            ans = cur;
            return;
        }
        // 优先分配给「空闲工人」
        if (used < K) {
            time[used] = jobss[idx];
            dfs(idx + 1, used + 1, time, Math.max(time[used], cur));
            time[used] = 0;
        }
        // 当前工作可以分配给哪个工人
        for(int i = 0; i < used; i++) {
            time[i] += jobss[idx];
            dfs(idx + 1, used, time, Math.max(cur, time[i]));
            time[i] -= jobss[idx];
        }
    }
}

