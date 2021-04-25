package leetcode.SpringRecruit.String;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/20 9:26
 */
public class Q28_实现strStr {
    // 暴力
    public int strStr1(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int n = cs.length;
        int m = ct.length;
        int i = 0, j = 0;
        while(i < n && j < m) {
            int start = i;
            if(cs[i] == ct[j]) {
                while(i < n && j < m && cs[i] == ct[j]) {
                    i++;j++;
                }
                if(j == m) {
                    break;
                }
                j = 0;
                i = start;
            }
            i++;
        }
        return j == m ? i - j : -1;
    }
    // 暴力优化
    public int strStr2(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int n = cs.length;
        int m = ct.length;
        int i = 0, j = 0;
        /*  优化：p串的下标取值范围[0, n - m], 即p串出现在s串最大的下标n - m的位置 */
        int max = n - m;
        while(i <= max && j < m) {
            int start = i;
            if(cs[i] == ct[j]) {
                while(i < n && j < m && cs[i] == ct[j]) {
                    i++;j++;
                }
                if(j == m) {
                    break;
                }
                j = 0;
                i = start;
            }
            i++;

        }
        return j == m ? i - j : -1;
    }
    // 暴力优化2
    class Solution {
        public int strStr(String haystack, String needle) {
            char[] s = haystack.toCharArray();
            char[] t = needle.toCharArray();
            int n = s.length, m = t.length;
            if(m == 0) {
                return 0;
            }
            for(int i = 0; i + m - 1 < n; i++) {
                boolean flag = true;
                for(int j = 0; j < m; j++) {
                    if(s[i + j] != t[j]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    return i;
                }
            }
            return -1;
        }
    }

    // KMP算法
    class Solution1 {
        public int strStr(String haystack, String needle) {
            char[] s = haystack.toCharArray();
            char[] t = needle.toCharArray();
            int i = 0, j = 0;
            int n = s.length, m = t.length;
            if(m == 0) {
                return 0;
            }
            int[] next = getNext(t);
            while(i < n) {
                if(j == -1 || s[i] == t[j]) {
                    i++; j++;
                } else {
                    j = next[j];
                }
                if(j == m) {
                    return i - m;
                }
            }
            return -1;
        }
        public int[] getNext(char[] t) {
            int n = t.length;
            int[] next = new int[n];
            next[0] = -1;
            int i = 0, j = -1;
            while(i < n - 1) {
                if(j == -1 || t[i] == t[j]) {
                    next[++i] = ++j;
                } else {
                    j = next[j];
                }
            }
            return next;
        }
    }
    // abab
    //  abab
    public static int[] getNext(char[] ct) {
        int n = ct.length;
        int[] next = new int[n];
        next[0] = -1;
        int i = 0, j = -1;
        while(i < n - 1) {
            if(j == -1 || ct[i] == ct[j]) {
                next[++i] = ++j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
    static int indexOf(char[] s, char[] p) {
        int n = s.length;
        int m = p.length;
        if (m == 0) {
            return 0;
        }
        char first = p[0];
        /*  优化：p串的下标取值范围[0, n - m], 即p串出现在s串最大的下标n - m的位置 */
        int max = (n - m);
        for (int i = 0; i <= max; i++) {
            while (i <= max && s[i] != first) {
                i++;
            }
            /* s中找到p的第一个字符，现在找p剩下部分 */
            if (i <= max) {
                int start = i;
                int end = i + m;
                int j = 0;
                while(i < end && s[i] == p[j]) {
                    i++; j++;
                }
                if (i == end) {
                    /* Found whole string. */
                    return i - m;
                } else {
                    i = start;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String a = "ababab";
        // ababab
        //  ababab
        int[] next = getNext(a.toCharArray());
        System.out.println(        Arrays.toString(next));
    }
}
