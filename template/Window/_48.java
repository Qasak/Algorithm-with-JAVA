package leetcode.template.Window;

import java.util.HashSet;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/20 12:10
 *
 * "abcabcbb"
 */
public class _48 {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int mxLen = 0;
        int l = 0;
        char[] cs = s.toCharArray();
        for(int i = 0; i < cs.length; i++) {
            while(set.contains(cs[i])) {
                set.remove(cs[l]);
                l++;
            }
            mxLen = Math.max(mxLen, i - l + 1);
            set.add(cs[i]);
        }
        return mxLen;
    }
}
