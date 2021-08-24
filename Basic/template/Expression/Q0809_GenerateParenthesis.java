package leetcode.template.Expression;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/23 11:15
 * 打印n对括号的所有合法的（例如，开闭一一对应）组合
 * n = 3
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * 解集不能包含重复的子集
 */

public class Q0809_GenerateParenthesis {
    // dfs1
    List<String> ans;
    int n;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        this.ans = new ArrayList<>();
        dfs(new StringBuilder(), 0, 0);
        return ans;
    }
    // cntl:左括号数量
    // cntr:右括号数量
    // (((
    // ((()))
    // (()())
    // (())()
    // ()(())
    // ()()()
    private void dfs(StringBuilder t, int cntl, int cntr) {
        if(cntl + cntr == 2 * n) {
            ans.add(t.toString());
        }
        if(cntl < n) {
            t.append('(');
            dfs(t, cntl + 1, cntr);
            t.deleteCharAt(t.length() - 1);
        }
        if(cntl > cntr) {
            t.append(')');
            dfs(t, cntl, cntr + 1);
            t.deleteCharAt(t.length() - 1);
        }
    }

    // dfs2
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis1(int n) {
        dfs(n, n, "");
        return res;
    }

    private void dfs(int left, int right, String curStr) {
        if (left == 0 && right == 0) { // 左右括号都不剩余了，递归终止
            res.add(curStr);
            return;
        }

        if (left > 0) { // 如果左括号还剩余的话，可以拼接左括号
            dfs(left - 1, right, curStr + "(");
        }
        if (right > left) { // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfs(left, right - 1, curStr + ")");
        }
    }
}
