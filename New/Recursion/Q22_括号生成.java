package leetcode.SpringRecruit.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/21 14:02
 */
public class Q22_括号生成 {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(0, 0, 0, n, new StringBuilder());
        return ans;
    }
    public void dfs(int l, int r, int len, int n, StringBuilder path) {
        if(len == n * 2) {
            ans.add(path.toString());
            return;
        }
        if(l < n) {
            path.append("(");
            dfs(l + 1, r, len + 1, n, path);
            path.setLength(path.length() - 1);
        }
        if(l > r) {
            path.append(")");
            dfs(l, r + 1, len + 1, n, path);
            path.setLength(path.length() - 1);
        }
    }
}
