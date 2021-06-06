package leetcode.contest.NiceProblem;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/6 19:55
 */
public class Q5778_使二进制字符串字符交替的最少反转次数 {
    public int minFlips(String s) {
        // 000111
        // 010101 : 2
        // 101010 : 4 =  n - 2
        // 按照0101
        int n = s.length();
        int ans = n;
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        for(int i = 0 ; i < n; i++) {
            a.append("01") ;
            b.append("10") ;
        }
        s = s + s;
        int d0 = 0, d1 = 0;
        String t0 = a.toString();
        String t1 = b.toString();
        for(int i = 0; i < 2 * n; i++) {
            // 入窗
            if(s.charAt(i) != t0.charAt(i)) {
                d0++;
            }
            if(s.charAt(i) != t1.charAt(i)) {
                d1++;
            }
            // 出窗
            if(i >= n) {
                if(s.charAt(i - n) != t0.charAt(i - n)) {
                    d0--;
                }
                if(s.charAt(i - n) != t1.charAt(i - n)) {
                    d1--;
                }
            }
            if(i >= n - 1) {
                ans = Math.min(ans, Math.min(d0, d1));
            }
        }
        return ans;
    }
}
