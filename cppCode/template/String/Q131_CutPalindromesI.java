package leetcode.template.String;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/31 15:03
 */
public class Q131_CutPalindromesI {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        dfs(s, 0, new LinkedList<>());
        return ans;
    }
    public void dfs(String s, int idx, List<String> path) {
        if(idx == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 1.枚举终点得到子串
        for(int i = idx; i < s.length(); i++) {
            // 2. 拿到字串，检查是否为回文
            if(!check(s, idx, i)) {
                continue;
            }
            // 3.检查后的字串加入结果，以子串终点的下一个字符为起点，进行下一次枚举
            path.add(s.substring(idx, i + 1));
            dfs(s, i + 1, path);
            // 4. 逐层退出
            path.remove(path.size() - 1);
        }
    }
    // [l, r]
    public boolean check(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++; r--;
        }
        return true;
    }


    // dp求出每个区间是否为回文
    boolean[][] dp;
    public List<List<String>> partition1(String s) {
        ans = new ArrayList<>();
        char[] cs = s.toCharArray();
        int n = cs.length;
        dp = new boolean[n + 1][n + 1];
        for(int len = 0; len < n; len++) {
            for(int i = 0; i + len < n; i++) {
                int j = i + len;
                if(len == 0) {
                    dp[i][j] = true;
                } else if(len == 1) {
                    dp[i][j] = (cs[i] == cs[j]);
                } else {
                    dp[i][j] = (dp[i + 1][j - 1] && (cs[i] == cs[j]));
                }
            }
        }
        dfs1(s, 0, new LinkedList<>());
        return ans;
    }
    public void dfs1(String s, int idx, List<String> path) {
        if(idx == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 1.枚举终点得到子串
        for(int i = idx; i < s.length(); i++) {
            // 2. 拿到字串，检查是否为回文
            if(!dp[idx][i]) {
                continue;
            }
            // 3.检查后的字串加入结果，以子串终点的下一个字符为起点，进行下一次枚举
            path.add(s.substring(idx, i + 1));
            dfs1(s, i + 1, path);
            // 4. 逐层退出
            path.remove(path.size() - 1);
        }
    }
}
