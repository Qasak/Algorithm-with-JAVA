package leetcode.SpringRecruit.StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/9 18:34
 */
public class Q20_有效的括号1 {
    public boolean isValid(String s) {
        char[] cs = s.toCharArray();
        Deque<Character> stk = new LinkedList<>();
        for(char c : cs) {
            if(c == '(' || c == '[' || c == '{') {
                stk.push(c);
            }
            if(c == ')') {
                if(stk.isEmpty() || stk.pop() != '(') {
                    return false;
                }
            }
            if(c == ']') {
                if(stk.isEmpty() || stk.pop() != '[') {
                    return false;
                }
            }
            if(c == '}') {
                if(stk.isEmpty() || stk.pop() != '{') {
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }
}
