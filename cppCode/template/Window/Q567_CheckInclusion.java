package leetcode.template.Window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/2 15:54
 */
public class Q567_CheckInclusion {
    // 超时
    public boolean checkInclusion(String s1, String s2) {
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char c: cs1) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int n = cs2.length;
        int m = cs1.length;
        int l = 0;
        Map<Character, Integer> map1 = new HashMap<>(map);
        for(int r = 0 ; r < n; r++) {
            int t = m;
            l = r;
            while(r < n && map1.containsKey(cs2[r]) && map1.get(cs2[r]) > 0) {
                t--;
                map1.put(cs2[r], map1.get(cs2[r]) - 1);
                r++;
            }
            if(t == 0) {
                return true;
            } else {
                map1 = new HashMap<>(map);
                r = l;
            }

        }
        return false;
    }
    // 优化
    public boolean checkInclusion1(String s1, String s2) {
        int n = s2.length();
        int m = s1.length();
        if(n < m) {
            return false;
        }
        if(n == m && s1.equals(s2)) {
            return true;
        }
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();

        int[] cnt = new int[26];
        int[] need = new int[26];
        for(char c: cs1) {
            need[c - 'a']++;
        }

        int l = 0;
        for(int r = 0 ; r < n; r++) {
            cnt[cs2[r] - 'a']++;
            if(r - l + 1 > m) {
                cnt[cs2[l] - 'a']--;
                l++;
            }
            if(Arrays.equals(need, cnt)) {
                return true;
            }
        }
        return false;
    }
    // 优化2
    // 1. s2包含s1的排列 == s2包含一个连续子串，这个子串满足每个出现的字符个数和s1相等。数组need统计s1中出现的各字符个数
    // 2. 令目标子串在s2中起始下标为l, 终止下标为r, 初始时l = r = 0。维护一个数组cnt，计数s2[l...r]之间各字母出现次数
    // 3. 令r向右移动，每次更新cnt值。若此时s2[r]数量大于need中对应字符的数量，则将l对应的计数--，直到当前字符s2[r]数量和need中的数量相等
    // 4. 比较当前窗口长度是否等于s1的长度
    public boolean checkInclusion2(String s1, String s2) {
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        int[] need = new int[26];
        int[] cnt = new int[26];
        for (char c : cs1) {
            need[c - 'a']++;
        }
        int l = 0;
        for (int r = 0; r < cs2.length; r++) {
            char c = cs2[r];
            cnt[c - 'a']++;
            while (cnt[c - 'a'] > need[c - 'a']) {
                char t = cs2[l];
                cnt[t - 'a']--;
                l++;
            }
            if (r - l + 1== cs1.length) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
    }
}
