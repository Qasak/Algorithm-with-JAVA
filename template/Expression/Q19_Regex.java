package leetcode.template.Expression;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/23 22:13
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释:因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 */
public class Q19_Regex {
    public boolean isMatch(String s, String p) {
        // p: ****
        // a*b
        // .*ab*.*b
        //
        //
        // "aaa"

        // "a.a" / "ab*ac*a"
        //


        // "ab*ac*a"
        // abbbacca
        // aaa

        // a.*a
        // axxxxa

        // a*
        // aaaaa

        // .*
        // xxxxx

        // ab
        // ab

        // s和P同时跑完才算OK
        if(p.isEmpty()) {
            return s.isEmpty();
        }

        // s = "ab"
        // p = ".*"
        // 输出: true
        // if(s.isEmpty()) {
        //     return true;
        // }
        // .a
        // aa
        // ba
        // ba
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        // 1.pattern 第二个是*
        // b*a
        // a

        // b*a
        // bbba


        // "ab"
        // ".*c"
        if(p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
            // 2.排除*的情况
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}
