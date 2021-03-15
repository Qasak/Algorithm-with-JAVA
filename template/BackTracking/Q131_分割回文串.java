package leetcode.template.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/7 15:52
 */
public class Q131_分割回文串 {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        dfs(0, new ArrayList<>(), s);
        return ans;
    }
    public void dfs(int idx, List<String> path, String s) {
        if(idx == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = idx; i < s.length(); i++) {
            if(!check(s.substring(idx, i + 1))) {
                continue;
            }
            path.add(s.substring(idx, i + 1));
            dfs(i + 1, path, s);
            path.remove(path.size() - 1);
        }
    }
    public boolean check(String s) {
        int n = s.length();
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
