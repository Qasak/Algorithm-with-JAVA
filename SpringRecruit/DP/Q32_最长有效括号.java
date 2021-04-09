package leetcode.SpringRecruit.DP;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/27 11:03
 */
public class Q32_最长有效括号 {
    // 1.栈
    public int longestValidParentheses(String s) {
        Deque<Integer> stk = new LinkedList<>();
        int ans = 0;
        int n = s.length();
        char[] cs = s.toCharArray();
        stk.push(-1);
        for(int i = 0; i < n; i++) {
            char c = cs[i];
            int len = 0;
            if(c == '(') {
                stk.push(i);
            } else {
                stk.pop();
                if(stk.isEmpty()) {
                    stk.push(i);
                } else {
                    len = i - stk.peek();
                }
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }

    // 2. DP
    public int longestValidParentheses1(String s) {
        // ((()))
        // ()()
        int n = s.length();
        if(n == 0) {
            return 0;
        }
        int ans = 0;
        int[] dp = new int[n];
        char[] cs = s.toCharArray();
        for(int i = 1; i < n; i++) {
            if(cs[i] == ')') {
                if(cs[i - 1] == '(') {
                    dp[i] = (i >= 2) ? dp[i - 2] + 2 : 2;
                } else if( i - dp[i - 1] - 1 >= 0 && cs[i - dp[i - 1] - 1] == '(') {
                    dp[i] = (i - dp[i - 1] - 2 >= 0) ? dp[i - 1] + 2 + dp[i - dp[i - 1] - 2] : dp[i - 1] + 2;
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
