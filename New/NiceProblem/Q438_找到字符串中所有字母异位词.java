package leetcode.contest.NiceProblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/8 16:25
 */
public class Q438_找到字符串中所有字母异位词 {
    // 固定大小的滑动窗口
    // 只需要一个指针
    public List<Integer> findAnagrams(String s, String p) {
        int[] cnt = new int[26];
        int[] need = new int[26];
        for(char c : p.toCharArray()) {
            need[c - 'a']++;
        }
        int n = s.length();
        int m = p.length();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
            if(i >= m) {
                cnt[s.charAt(i - m) - 'a']--;
            }
            if(i >= m - 1) {
                if(check(cnt, need)) {
                    ans.add(i - m + 1);
                }
            }
        }
        return ans;
    }
    private boolean check(int[] cnt, int[] need) {
        for(int i = 0; i < 26; i++) {
            if(cnt[i] != need[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Set<Character> set = new HashSet<>();
        Set<Character> set1 = new HashSet<>();
        System.out.println(set.equals(set1));
    }
}
