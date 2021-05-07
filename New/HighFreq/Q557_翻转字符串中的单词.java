package leetcode.HighFreq;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/27 9:17
 */
public class Q557_翻转字符串中的单词 {
    public String reverseWords(String s) {
        char[] cs = s.toCharArray();
        boolean flag = true;
        int n = cs.length;
        int l = 0, r = 0;

        while(r <= n) {
            if(r == n || cs[r] == ' ') {
                int a = l, b = r - 1;
                while(a < b) {
                    swap(cs, a, b);
                    a++;b--;
                }
                l = r + 1;
            }
            r++;
        }
        StringBuilder ans = new StringBuilder();
        for(char c : cs) {
            ans.append(c);
        }
        return ans.toString();

    }
    private void swap(char[] cs, int i, int j) {
        char t = cs[i];
        cs[i] = cs[j];
        cs[j] = t;
    }

    public String reverseWords1(String s) {
        String[] strs = s.split(" ");
        StringBuilder ans = new StringBuilder();
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            ans.append(new StringBuilder(strs[i]).reverse().toString());
            if(i != n - 1) {
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}
