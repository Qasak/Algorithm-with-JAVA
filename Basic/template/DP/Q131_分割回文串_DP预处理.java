package leetcode.template.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/7 15:52
 */
public class Q131_分割回文串_DP预处理 {
    boolean[][] dp;
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        ans = new ArrayList<>();
        dp = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], true);
        }
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                dp[i][j] = cs[i] == cs[j] && dp[i + 1][j - 1];
            }
        }
        dfs(0, s, new ArrayList<>());
        return ans;
    }
    public void dfs(int idx, String s, List<String> path) {
        if(idx == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = idx; i < s.length(); i++) {
            if(dp[idx][i]) {
                path.add(s.substring(idx, i + 1));
                dfs(i + 1, s, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
