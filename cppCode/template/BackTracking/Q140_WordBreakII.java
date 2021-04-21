package leetcode.template.BackTracking;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/1 15:09
 */
public class Q140_WordBreakII {
    List<String> ans;
    Set<String> set;
    // 1. DFS 超时
    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        ans = new ArrayList<>();
        dfs(s, 0, new StringBuilder());
        return ans;
    }
    public void dfs(String s, int idx, StringBuilder sb) {
        int len = sb.length();
        if(idx == s.length()) {
            sb.setLength(len - 1);
            ans.add(sb.toString());
            return;
        }
        for(int i = idx; i < s.length(); i++) {
            if(set.contains(s.substring(idx, i + 1))) {
                sb.append(s.substring(idx, i + 1));
                sb.append(' ');
                dfs(s, i + 1, sb);
                sb.setLength(len);
            }
        }
    }
    // 记忆化
    int[] dp;
    public List<String> wordBreak1(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        ans = new ArrayList<>();
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        dfs1(s, 0, new StringBuilder());
        return ans;
    }

    public int dfs1(String s, int idx, StringBuilder sb) {
        int len = sb.length();
        if(idx == s.length()) {
            sb.setLength(len - 1);
            ans.add(sb.toString());
            return 1;
        }
        if(dp[idx] == 0) {
            return dp[idx];
        }
        boolean flag = false;
        for(int i = idx; i < s.length(); i++) {
            if(set.contains(s.substring(idx, i + 1))) {
                sb.append(s.substring(idx, i + 1));
                sb.append(' ');
                if(dfs1(s, i + 1, sb) == 1) {
                    flag = true;
                    dp[idx] = 1;
                }
                sb.setLength(len);
            }
        }
        if(!flag) {
            return dp[idx] = 0;
        }
        return dp[idx];
    }
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
    }
}
