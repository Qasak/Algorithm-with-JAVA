package leetcode.template.String;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/23 9:25
 */
public class Q387_FirstUniq {
    public int firstUniqChar(String s) {
        // abbcc
        // abcbc
        // bbcca
        // bbacc
        // aabbcc
        // abbc
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] cnt = new int[26];
        for(char c: cs) {
            cnt[c - 'a']++;
        }
        for(int i = 0; i < n; i++) {
            if(cnt[cs[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
