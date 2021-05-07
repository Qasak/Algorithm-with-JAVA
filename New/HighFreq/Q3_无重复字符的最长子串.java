package leetcode.HighFreq;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/24 19:23
 */
public class Q3_无重复字符的最长子串 {
    // 暴力 选择每一个起始位置开始到终点： O(n^2)
    // 滑动窗口：遇到重复字符时，在重复字符出现前的那些子串的终点必定是r，故可以全部抛弃，直到cs[l] == cs[r]
    public int lengthOfLongestSubstring(String s) {
        char[] cs = s.toCharArray();
        int ans = 0;
        int l = 0;
        Set<Character> set = new HashSet<>();
        int n = cs.length;
        for(int r = 0; r < n; r++) {
            if(!set.add(cs[r])) {
                while(l <= r && cs[l] != cs[r]) {
                    set.remove(cs[l++]);
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
    // 至多包含k个重复字符的最长子串
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] cs = s.toCharArray();
        int ans = 0;
        int l = 0;
        int n = cs.length;
        Map<Character, Integer> map = new HashMap<>();
        for(int r = 0; r < n; r++) {
            map.put(cs[r], map.getOrDefault(cs[r], 0) + 1);
            if(map.get(cs[r]) > k) {
                while(l < r && map.get(cs[r]) > k) {
                    map.put(cs[l], map.get(cs[l]) - 1);
                    l++;
                }
                l++;
            }

            System.out.println(l + " " + r);
            ans = Math.max(ans, r - l + 1);
        }
        System.out.println(map);
        return ans;
    }
    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>();
        set.add(1);
    }
}
