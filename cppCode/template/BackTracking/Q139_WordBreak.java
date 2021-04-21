package leetcode.template.BackTracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/1 15:21
 */
public class Q139_WordBreak {
    Set<String> set;
    // 1. DFS 超时
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        return dfs(s, 0);
    }
    public boolean dfs(String s, int idx) {
        if(idx == s.length()) {
            return true;
        }
        for(int i = idx; i < s.length(); i++) {
            if(set.contains(s.substring(idx, i + 1))) {
                if(dfs(s, i + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
    // 2. 记忆化

    // dp数组记录枚举到以idx开头时可否拆分
    // 典型用例："aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    //["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
    int[] dp;
    public boolean wordBreak1(String s, List<String> wordDict) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        set = new HashSet<>(wordDict);
        return dfs1(s, 0) == 1;
    }
    public int dfs1(String s, int idx) {
        if(idx == s.length()) {
            return dp[idx - 1] = 1;
        }
        if(dp[idx] != -1) {
            return dp[idx];
        }
        for(int i = idx; i < s.length(); i++) {
            if(set.contains(s.substring(idx, i + 1))) {
                if(dfs1(s, i + 1) == 1) {
                    return dp[idx] = 1;
                }
            }
        }
        return dp[idx] = 0;
    }
}
