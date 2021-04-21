package leetcode.template.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/2 15:48
 */
public class Q22_GenerateParenthesis {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();

        dfs(new StringBuilder(), n, 0, 0);
        return ans;
    }
    // left : 已用的左括号
    // right : 已用的右括号
    public void dfs(StringBuilder t, int n, int left, int right) {
        if(left == right && left + right == 2 * n) {
            ans.add(t.toString());
            return;
        }

        if(left < n) {
            t.append('(');
            dfs(t, n, left + 1, right);
            t.deleteCharAt(t.length() - 1);
        }
        if(left > right) {
            t.append(')');
            dfs(t, n, left, right + 1);
            t.deleteCharAt(t.length() - 1);
        }
    }
}
