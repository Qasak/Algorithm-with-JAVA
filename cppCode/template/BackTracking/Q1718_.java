package leetcode.template.BackTracking;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/9 16:52
 */
public class Q1718_ {
    int[] ans;
    boolean[] vis;
    public int[] constructDistancedSequence(int n) {
        ans = new int[1 + (n - 1) * 2];
        vis = new boolean[n + 1];
        dfs(0);
        return ans;
    }
    private boolean dfs(int idx) {
        if(idx == ans.length) {
            return true;
        }
        if(ans[idx] != 0) {
            return dfs(idx + 1);
        }
        for(int i = vis.length - 1; i >= 1; i--) {
            if(i == 1 && !vis[i] ) {
                ans[idx] = 1;
                vis[1] = true;

                if(dfs(idx + 1)) {
                    return true;
                }
                vis[i] = false;
                ans[idx] = 0;
                continue;
            }
            if(!vis[i] && idx + i < ans.length && ans[idx + i] == 0) {
                ans[idx] = ans[idx + i] = i;
                vis[i] = true;

                if(dfs(idx + 1)) {
                    return true;
                }
                vis[i] = false;
                ans[idx] = ans[idx + i] = 0;
            }
        }
        return false;
    }
}
