package leetcode.HighFreq;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/25 18:33
 */
public class Q76_最小覆盖子串 {
    public String minWindow(String s, String t) {

        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int n = cs.length;
        int m = ct.length;
        if(m > n) {
            return "";
        }
        if(s.equals(t)) {
            return s;
        }
        int ans = (int) 1e5 + 1;
        int x = -1, y = -1;
        // "XXXXXXXXXBANC"
        int[] cntS = new int[128];
        int[] cntT = new int[128];
        Set<Character> set = new HashSet<>();
        for(char c : ct) {
            cntT[c]++;
            set.add(c);
        }
        int l = 0;
        // 枚举终点
        for(int r = 0; r < n; r++) {
            cntS[cs[r]]++;
            if(check(cntS, cntT, set)) {
                while(check(cntS, cntT, set)) {
                    cntS[cs[l++]]--;
                }
                if(r - l + 2 < ans) {
                    x = l - 1;
                    y = r;
                    ans = r - l + 2;
                }
            }
        }
        return x == -1 ? "" : s.substring(x, y + 1);
    }
    public boolean check(int[] cntS, int[] cntT, Set<Character> set) {
        for(int i = 0; i < 128; i++) {
            char ch = (char) i;
            if(set.contains(ch)) {
                if(cntS[i] < cntT[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
