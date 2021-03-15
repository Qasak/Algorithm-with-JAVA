package leetcode.template.Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/10 9:42
 */
public class Q224_基本计算器 {
    public int calculate(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        Deque<Integer> ops = new LinkedList<>();
        int sign = 1;
        ops.push(sign);
        int ans = 0;
        for(int i = 0; i < n; ) {
            if(cs[i] == ' ') {
                i++;
            } else if(cs[i] == '+') {
                sign = ops.peek();
                i++;
            } else if(cs[i] == '-') {
                sign = -ops.peek();
                i++;
            } else if(cs[i] == '(') {
                ops.push(sign);
                i++;
            } else if(cs[i] == ')') {
                ops.pop();
                i++;
            } else {
                int cur = 0;
                while(i < n && cs[i] >= '0' && cs[i] <= '9') {
                    cur = cur * 10 + (cs[i] - '0');
                    i++;
                }
                ans += sign * cur;
            }
        }
        return  ans;

    }
}
