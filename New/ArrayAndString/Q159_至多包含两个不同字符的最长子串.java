package leetcode.SpringRecruit.ArrayAndString;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/22 14:43
 */
public class Q159_至多包含两个不同字符的最长子串 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int ans = 0;
        int l = 0;
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while(l < n && map.size() > 2) {
                char c = s.charAt(l);
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) {
                    map.remove(c);
                }
                l++;
            }
            ans = Math.max(ans, i - l + 1);
        }
        return ans;
    }
}
