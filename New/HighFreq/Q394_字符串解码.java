package leetcode.HighFreq;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/27 13:01
 */
public class Q394_字符串解码 {
    public String decodeString(String s) {
        // 倍数入栈
        // 字符串入栈
        // 右括号：字符串出栈 ✖ 倍数 ，拼接到现有串
        // "a2[b2[c2[d]e]]g"
        char[] cs = s.toCharArray();
        int n = cs.length;
        int i = 0;
        int num = 0;
        StringBuilder cur = new StringBuilder();
        Deque<Integer> a = new LinkedList<>();
        Deque<String> b = new LinkedList<>();
        while(i < n) {
            if(Character.isDigit(cs[i])) {
                while(i < n && Character.isDigit(cs[i])) {
                    num = num * 10 + cs[i] - '0';
                    i++;
                }
            } else if(Character.isLetter(cs[i])) {
                while(i < n && Character.isLetter(cs[i])) {
                    cur.append(cs[i]);
                    i++;
                }
            } else if(cs[i] == '[') {
                a.push(num);
                b.push(cur.toString());
                num = 0;
                cur = new StringBuilder();
                i++;
            } else {
                // ] 出栈
                int m = a.pop();
                StringBuilder t = new StringBuilder();
                t.append(b.pop());
                for(int j = 0; j < m; j++) {
                    t.append(cur);
                }
                cur = t;
                i++;
            }
        }
        return cur.toString();
    }
    public static void main(String[] args) {
        StringBuilder a = new StringBuilder();
        a.append("11");
        StringBuilder b = new StringBuilder();
        b.append(a);
    }
}
