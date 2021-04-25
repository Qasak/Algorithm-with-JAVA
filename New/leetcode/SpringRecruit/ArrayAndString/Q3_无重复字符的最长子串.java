package leetcode.SpringRecruit.ArrayAndString;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/21 13:53
 */
public class Q3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int n = s.length();
        // bcadabcxyz
        int l = 0;
        Set<Character> set = new HashSet<>();
        for(int r = 0; r < n; r++) {
            if(set.add(s.charAt(r))) {
                ans = Math.max(ans, r - l + 1);
                continue;
            }
            while(l < r && s.charAt(l) != s.charAt(r)) {
                set.remove(s.charAt(l++));
            }
            l++;
        }
        return ans;
    }
}
