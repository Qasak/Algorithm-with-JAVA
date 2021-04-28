package leetcode.SpringRecruit.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/16 14:46
 */
public class Q87_扰乱字符串 {
    // 1. 朴素dfs
    class Solution {
        public boolean isScramble(String s1, String s2) {
            if(s1.equals(s2)) {
                return true;
            }
            if(!check(s1, s2)) {
                return false;
            }
            int n = s1.length();
            // 1234 567 1234 567
            // 1234 567 567 1234

            // s1的切法是一定的，只是切出来的部分对应s2的位置不同
            for(int i = 1; i < n; i++) {
                if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, n), s2.substring(i, n))) {
                    return true;
                }
                if(isScramble(s1.substring(0, i), s2.substring(n - i, n)) && isScramble(s1.substring(i, n), s2.substring(0, n - i))) {
                    return true;
                }
            }
            return false;
        }
        // 检查 s1 和 s2 词频是否相同
        boolean check(String s1, String s2) {
            int n = s1.length();
            int[] cnt1 = new int[26], cnt2 = new int[26];
            char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
            for (int i = 0; i < n; i++) {
                cnt1[cs1[i] - 'a']++;
                cnt2[cs2[i] - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (cnt1[i] != cnt2[i]) return false;
            }
            return true;
        }
    }

    // 2. 子串划分 + 记忆化
    class Solution2 {
        // -1 访问过，但不行，0 未访问，1 访问过，可以
        int[][][] cache;
        public boolean isScramble(String s1, String s2) {
            int n = s1.length();
            cache = new int[n][n][n + 1];
            // 两个串的起点+长度可以唯一确定一个子问题
            boolean ans = dfs(s1, s2, 0, 0, n);
            return ans;
        }

        public boolean dfs(String s1, String s2, int i, int j, int len) {

            String a = s1.substring(i, i + len);
            String b = s2.substring(j, j + len);
            if(cache[i][j][len] != 0) {
                return cache[i][j][len] == 1;
            }
            if(!check(a, b)) {

                cache[i][j][len] = -1;
                return false;
            }
            if(a.equals(b)) {
                cache[i][j][len] = 1;
                return true;
            }

            int n = a.length();
            // s1的切法是一定的，只是切出来的部分对应s2的位置不同
            // 切出来对应后半段，相当于[交换两个字符串]
            boolean l = false, r = false;
            for(int p = 1; p < n; p++) {
                if(dfs(s1, s2, i, j, p) &&
                        dfs(s1, s2, p + i, p + j, n - p)) {
                    l = true;
                }
                if(dfs(s1, s2, i, n - p + j, p) &&
                        dfs(s1, s2, p + i, j, n - p)) {
                    r = true;
                }
                if(l || r) {
                    cache[i][j][len] = 1;
                    return true;
                }
            }

            cache[i][j][len] = -1;
            return false;
        }
        // 检查 s1 和 s2 词频是否相同
        boolean check(String s1, String s2) {
            int n = s1.length();
            int[] cnt1 = new int[26], cnt2 = new int[26];
            char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
            for (int i = 0; i < n; i++) {
                cnt1[cs1[i] - 'a']++;
                cnt2[cs2[i] - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (cnt1[i] != cnt2[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Q87_扰乱字符串 q = new Q87_扰乱字符串();
        String a = "eebeebaacbcbcadaaedceaaacadccdaacbcbcadaaedceaaacadccd";
        String b = "eadcaacabeebaacbcbcadaaedceaaacadccdaddaceacbceaabeccd";
        Q87_扰乱字符串.Solution2 solution2 = q.new Solution2();
        System.out.println(solution2.isScramble(a, b));

    }
}
