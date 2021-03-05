package leetcode.template.Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/1 18:00
 */
public class Q20_brackts {
    public boolean isValid(String s) {
        Deque<Character> stk = new LinkedList<>();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                stk.push(c);
            } else {
                if(stk.isEmpty()) {
                    return false;
                }
                char pre = stk.pop();
                if(c == ')') {
                    if(pre != '(') {
                        return false;
                    }
                } else if(c == ']') {
                    if(pre != '[') {
                        return false;
                    }
                } else {
                    if(pre != '{') {
                        return false;
                    }
                }
            }
        }
        return stk.isEmpty();
    }
}
