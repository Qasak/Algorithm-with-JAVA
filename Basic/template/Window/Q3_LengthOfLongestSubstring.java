package leetcode.template.Window;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/2 17:56
 */
public class Q3_LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int ans = 0;
        int l = 0;
        Set<Character> set = new HashSet<>();
        for(int r = 0; r < n; r++) {
            if(!set.add(cs[r])) {
                while(cs[l] != cs[r]) {
                    set.remove(cs[l]);
                    l++;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
