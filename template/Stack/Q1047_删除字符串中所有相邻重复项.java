package leetcode.template.Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/9 9:55
 */
public class Q1047_删除字符串中所有相邻重复项 {
    public String removeDuplicates(String S) {
        char[] cs = S.toCharArray();
        Deque<Character> stk = new LinkedList<>();
        int n = cs.length;
        for(int i = 0; i < n; i++) {
            if(!stk.isEmpty() && cs[i] == stk.peek()) {
                stk.pop();
            } else {
                stk.push(cs[i]);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!stk.isEmpty()) {
            ans.append(stk.pollLast());
        }
        return ans.toString();
    }

    public String removeDuplicates1(String S) {
        if(S.length() == 1) {
            return S;
        }
        char[] cs = S.toCharArray();
        int index = -1;
        for (char c : cs) {
            if (index != -1 && c == cs[index]) {
                index--;
            } else {
                index++;
                cs[index] = c;
            }
        }
        return new String(cs, 0, index + 1);
    }
}
