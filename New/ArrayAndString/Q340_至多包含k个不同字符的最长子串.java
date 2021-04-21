package leetcode.SpringRecruit.ArrayAndString;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/22 14:45
 */
public class Q340_至多包含k个不同字符的最长子串 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int ans = 0;
        int l = 0;
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while(l < n && map.size() > k) {
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

    public static void main(String[] args) {
        String a = "aaac";
        Character[] b = new Character[]{'a', 'b'};
        Set<Character> set = new HashSet<>(Arrays.asList(b));

    }
}
