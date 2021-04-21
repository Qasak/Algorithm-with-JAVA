package leetcode.template.Array;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/8 11:27
 */
public class Q186_ReverseWords {
    public void reverseWords(char[] s) {
        // the sky is blue
        // blue is sky the
        // a b c d
        //       a
        // eulb
        int n = s.length;
        if(n == 0) {
            return;
        }
        reverse(s, 0, n - 1);
        int j = 0;
        for(int i = 0; i < n; i++) {
            if(s[i] == ' ') {
                reverse(s, j, i - 1);
                j = i + 1;
            }
            if(i == n - 1) {
                reverse(s, j, n - 1);
            }
        }
    }
    private void reverse(char[] s, int l, int r) {
        while(l < r) {
            char t = s[l];
            s[l] = s[r];
            s[r] = t;
            l++;
            r--;
        }

    }
}
