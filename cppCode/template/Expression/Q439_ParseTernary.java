package leetcode.template.Expression;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/23 11:08
 */
public class Q439_ParseTernary {
    // 递归1
    public String parseTernary(String s) {
        // 条件T/F
        // "T?2:3"
        // 2
        // "F?2:3"
        // 3

        // "T?T:3"
        // T

        // "F?T:F"
        // F

        // "F?1:T?4:5"
        // T/F?e1:e2
        //

        char c = s.charAt(0);
        int p = 0;
        int n = s.length();
        if(n == 1) {
            return s;
        }
        // "T?T?F:5:T?F:5"
        // e1 = T?F
        int cnt = 0;
        for(int i = 2; i < n; i++) {
            if(s.charAt(i) == '?') {
                cnt++;
            }
            if(s.charAt(i) == ':' ) {
                if(cnt == 0) {
                    p = i;
                    break;
                }
                cnt--;
            }
        }
        String e1 = s.substring(2, p);
        String e2 = s.substring(p + 1, n);
        if(c == 'T') {
            return parseTernary(e1);
        } else {
            return parseTernary(e2);
        }
    }
    // 递归2
//    public String parseTernary1(String s) {
//        int n = s.length();
//        if(n == 1) {
//            return s;
//        }
//        for()
//    }
    //栈
    // 从后向前入栈，遇到问号就判断并出栈。
    public static String parseTernary2(String s) {
        int n = s.length();

        // "T?F?T:4:T?F:T:5"
        Deque<Character> stk = new LinkedList<>();
        for(int i = n - 1; i >= 0; i--) {
            System.out.println(stk);
            if(s.charAt(i) == '?') {
                char a = stk.pop();
                char b = stk.pop();
                boolean cur = s.charAt(--i) == 'T';
                stk.push(cur ? a : b);
            } else if(s.charAt(i) != ':') {
                stk.push(s.charAt(i));
            }
        }
        return String.valueOf(stk.peek());
    }

    public static void main(String[] args) {
        parseTernary2("T?F?T:4:T?F:T:5");
    }
}
