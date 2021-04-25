package leetcode.SpringRecruit.StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/22 18:25
 */
public class Q224_基本计算器 {
    public int calculate(String s) {
        int n = s.length();
        long ans = 0;
        Deque<Integer> stk = new LinkedList<>();
        stk.push(1);
        int sign = 1;
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == ' ') {
                continue;
            } else if(ch == '+') {
                sign = stk.peek();
            } else if(ch == '-' ) {
                sign = -stk.peek();
            } else if(ch == '(') {
                stk.push(sign);
            } else if(ch == ')') {
                stk.pop();
            } else {
                long cur = 0;
                while(i < n && Character.isDigit(s.charAt(i))) {
                    cur = cur * 10 + s.charAt(i) - '0';
                    i++;
                }
                ans += sign * cur;
                i--;
            }
        }
        // -(2-(2-(-2)))
        // -2 + 2 + 2
        //
        return (int) ans;
    }
}
