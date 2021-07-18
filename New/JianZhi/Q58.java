package leetcode.JianZhi;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/22 9:36
 */
public class Q58 {
    public String reverseWords(String s) {
        s = s.trim();
        String[] t = s.split("\\s+");
        StringBuilder ans = new StringBuilder();
        for(int i = t.length - 1; i >= 0; i--) {
            ans.append(t[i]);
            if(i == 0) {
                break;
            }
            ans.append(' ');
        }
        return ans.toString();
    }

    public String reverseWords1(String s) {
        StringBuilder ans = new StringBuilder();
        s = s.trim();
        char[] cs = s.toCharArray();
        int n = cs.length;
        Deque<String> stk = new LinkedList<>();
        for(int i = 0; i < n;) {
            while(i < n && cs[i] == ' ') {
                i++;
            }
            StringBuilder tmp = new StringBuilder();
            while(i < n && cs[i] != ' ') {
                tmp.append(cs[i]);
                i++;
            }
            stk.push(tmp.toString());
        }
        while(!stk.isEmpty()) {
            ans.append(stk.pop());
            if(!stk.isEmpty()) {
                ans.append(' ');
            }
        }
        return ans.toString();
    }
}
