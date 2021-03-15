package leetcode.template.Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/11 9:20
 */
public class Q150_逆波兰表达式_后缀表达式 {
    public int evalRPN(String[] tokens) {
        // Deque<Character> ops = new LinkedList<>();
        Deque<Integer> stk = new LinkedList<>();
        int n = tokens.length;
        for(int i = 0; i < n; i++) {
            if((tokens[i].charAt(0) <= '9' && tokens[i].charAt(0) >= '0') || (tokens[i].charAt(0) == '-' && tokens[i].length() > 1)) {
                stk.push(Integer.valueOf(tokens[i]));
            } else {
                if(tokens[i].charAt(0) == '+') {
                    stk.push(stk.pop() + stk.pop());
                } else if(tokens[i].charAt(0) == '-') {
                    stk.push(-stk.pop() + stk.pop());

                } else if(tokens[i].charAt(0) == '*') {
                    stk.push(stk.pop() * stk.pop());

                } else {
                    int a = stk.pop();
                    int b = stk.pop();
                    stk.push(b / a);
                }
            }
        }
        return stk.pop();
    }
}
