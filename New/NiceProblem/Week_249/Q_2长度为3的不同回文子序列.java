package leetcode.contest.Week_249;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/11 23:39
 */
public class Q_2长度为3的不同回文子序列 {
    public int countPalindromicSubsequence(String s) {
        int ans = 0;
        int n = s.length();
        char[] cs = s.toCharArray();
        for(int i = 0; i < 26; i++) {
            char ch = (char) (i + 'a');
            int l = 0, r = n - 1;
            while(l < r) {
                if(cs[l] != ch) {
                    l++;
                } else if(cs[r] != ch) {
                    r--;
                } else {
                    break;
                }
            }
            if(r - l < 2) {
                continue;
            }
            Set<Character> set = new HashSet<>();
            for(int j = l + 1; j < r; j++) {
                set.add(cs[j]);
            }
            ans += set.size();
        }
        return ans;
    }
}
