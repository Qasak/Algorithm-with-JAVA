package leetcode.contest.NiceProblem.位运算技巧;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/13 22:41
 */
public class Q1680_连接连续二进制数字 {
    public int concatenatedBinary(int n) {
        int mod = (int)(1e9 + 7);
        int shift = 0;
        long ans = 0;
        for(int i = 1; i <= n; i++) {
            // 是2的幂 进位
            if((i & (i - 1)) == 0) {
                shift++;
            }
            ans = ((ans << shift) | i) % mod;
        }
        return (int) ans;
    }
}
