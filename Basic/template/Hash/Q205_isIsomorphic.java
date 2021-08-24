package leetcode.template.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/27 1:01
 *
 *
 *  s = "egg", t = "add"
 */
public class Q205_isIsomorphic {
    // 暴力 indexOf
    public boolean isIsomorphic1(String s, String t) {
        int i=0;
        while(i < s.length()) {
            if(s.indexOf(s.charAt(i))!=t.indexOf(t.charAt(i))) {
                return false;
            }
            i++;
        }
        return true;
    }
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                if(map.get(c) != t.charAt(i)) {
                    return false;
                }
            } else {
                map.put(c, t.charAt(i));
            }
        }
        map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            char c = t.charAt(i);
            if(map.containsKey(c)) {
                if(map.get(c) != s.charAt(i)) {
                    return false;
                }
            } else {
                map.put(c, s.charAt(i));
            }
        }
        return true;
    }
    //
    public boolean isIsomorphic3(String s, String t) {
        int[] cnt1 = new int[256];
        int[] cnt2 = new int[256];
        int n = s.length();
        // aabb
        // abba

        // abbaa
        // cddcd
        for (int i = 0; i < n; i++) {
            if (cnt1[s.charAt(i)] != cnt2[t.charAt(i)]) {
                return false;
            }
            cnt1[s.charAt(i)] = i + 1;
            cnt2[t.charAt(i)] = i + 1;
        }
        return true;
    }
    // HashMap official
    public boolean isIsomorphic4(String s, String t) {
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }

}
