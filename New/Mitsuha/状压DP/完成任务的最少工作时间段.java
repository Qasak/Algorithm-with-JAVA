// 回溯 超时
class Solution1 {
    int ans = 1000;
    int n;
    boolean[] vis;
    // boolean[][][] f;
    public int minSessions(int[] tasks, int sessionTime) {
        Arrays.sort(tasks);
        // System.out.println(Arrays.toString(tasks));
        n = tasks.length;
        vis = new boolean[n];
        // i, cur, sum
        // f = new boolean[15][15][200];
        dfs(0, 0, 1, tasks, sessionTime, sessionTime, 0);
        return ans;
    }
    // cur : 线段数
    void dfs(int i, int cnt, int cur, int[] tasks, int curSession, int sessionTime, int sum) {
        if(cur >= ans) {
            return;
        }
        if(cnt == n) {
            ans = Math.min(ans, cur);
            return;
        }
        // if(f[i][cur][sum]) {
        //     return;
        // }
        for(int j = 0; j < n; j++) {
            if(vis[j] ) {
                continue;
            }
            vis[j] = true;
            if(curSession >= tasks[j]) {
                dfs(j, cnt + 1, cur, tasks, curSession - tasks[j], sessionTime, sum + tasks[j]);
            } else {
                dfs(j, cnt + 1, cur + 1, tasks, sessionTime - tasks[j], sessionTime, sum + tasks[j]);
            }
            vis[j] = false;
        }
        // f[i][cur][sum] = true;
    }
}

class Solution2 {
    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        int INF = 0x3f3f3f3f;
        // f[i] : 状态i的最小值
        int[] f = new int[1 << n];
        Arrays.fill(f, INF);
        for(int i = 1; i < (1 << n); i++) {
            int spend = 0, status = i, idx = 0;
            while(status > 0) {
                if((status & 1) == 1) {
                    spend += tasks[idx];
                }
                idx++;
                status >>= 1;
            }
            if(spend <= sessionTime) {
                f[i] = 1;
            }
        }        
        for(int i = 1; i < (1 << n); i++) {
            for(int j = i; j > 0; j = (j - 1) & i) {
                f[i] = Math.min(f[i], f[j] + f[i ^ j]);
            }
        }
        return f[(1 << n) - 1];
    }
}