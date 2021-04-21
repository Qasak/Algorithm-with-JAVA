package leetcode.template.String;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/22 19:02
 */
public class KMP {
    // t 在 s 中是否存在，存在则返回下标
    // KMP算法
    public int strStr(String s, String t) {
        if(s == null || t == null || s.length() < t.length()) {
            return -1;
        }
        if(t.length() == 0) {
            return 0;
        }
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] next = getNext(ct);
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while(i < n && j < m) {
            if(j == -1 || cs[i] == ct[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return j == m ? i - j : -1;
    }
    private int[] getNext(char[] ct) {
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

    public static void main(String[] args) {


    }
}
