package leetcode.contest.NiceProblem;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/13 17:18
 */
public class Q29_两数相除 {
    public int divide(int dividend, int divisor) {
        boolean isNeg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        long y = dividend;
        long x = divisor;
        if(y < 0) {
            y = -y;
        }
        if(x < 0) {
            x = -x;
        }
        // (]
        long l = 0, r = y;
        while(l < r) {
            long m = (l + r + 1) >>> 1;
            if(y >= mul(x, m)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        long ans = isNeg ? -l: l;
        if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) ans;
    }
    // a * x
    private long mul(long a, long x) {
        long ans = 0;
        while(x > 0) {
            if((x & 1) == 1) {
                ans += a;
            }
            a += a;
            x >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
