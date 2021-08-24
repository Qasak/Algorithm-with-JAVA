package leetcode.template.Expression;

import leetcode.contest.WeekContest_217.A;

import java.util.ArrayList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/23 10:13
 *
 * !(f) -> true
 * |(f,t)-> true
 * &(t,f)->false
 * |(&(t,f,t),!(t))->false
 *
 */
public class Q1106_ParseBoolExpr {
    // |(&(t,f,t),!(t))
    // ans = |(A, B)
    // A = &(t,f,t) = false
    // B = !(t) = false
    // ans = |(false, false) = false

    // t -> true
    // !(t)
    public static boolean parseBoolExpr(String s) {
        int n = s.length();
        if(n == 1){
            return s.charAt(0) == 't';
        }
        // ?(...)
        char exp = s.charAt(0);
        if(exp == '!') {
            return !parseBoolExpr(s.substring(2, n - 1));
        } else if(exp == '&') {
            // &(A, B, C)
            boolean ans = true;
            // 不能split表达式内部的','
//            String[] t = s.substring(2, n - 1).split(",");
            // &(t,f,t),!(t)
            ArrayList<String> t = new ArrayList<>();
            int cnt = 0;
            int start = 2;
            for(int i = 2; i < n - 1; i++) {
                if(s.charAt(i) == '(') {
                    cnt++;
                }
                if(s.charAt(i) == ')') {
                    cnt--;
                }
                if(s.charAt(i) == ',' && cnt == 0) {
                    t.add(s.substring(start, i));
                    start = i + 1;
                }
            }
            t.add(s.substring(start, n - 1));
            for(String i: t) {
                ans = ans && parseBoolExpr(i);
            }
            return ans;
        } else {
            boolean ans = false;
//            String[] t = s.substring(2, n - 1).split(",");
            ArrayList<String> t = new ArrayList<>();
            int cnt = 0;
            int start = 2;
            for(int i = 2; i < n - 1; i++) {
                if(s.charAt(i) == '(') {
                    cnt++;
                }
                if(s.charAt(i) == ')') {
                    cnt--;
                }
                if(s.charAt(i) == ',' && cnt == 0) {
                    t.add(s.substring(start, i));
                    start = i + 1;
                }
            }
            t.add(s.substring(start, n - 1));

            for(String i: t) {
                ans = ans || parseBoolExpr(i);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        parseBoolExpr("|(&(t,t,t),!(t))");
    }
}
