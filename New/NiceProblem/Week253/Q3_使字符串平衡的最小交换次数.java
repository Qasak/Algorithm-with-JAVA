package leetcode.contest.Week253;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/8 18:11
 */
public class Q3_使字符串平衡的最小交换次数 {
    public int minSwaps(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int match = 0;
        int unMatch = 0;
        Deque<Character> stk = new LinkedList<>();
        for(char c : cs) {
            if(c == ']') {
                if(!stk.isEmpty()) {
                    match++;
                    stk.pop();
                }
            } else {
                stk.push(c);
            }
        }
        unMatch = n / 2 - match;
        return (unMatch + 1) / 2;
    }
}
