package leetcode.contest.NiceProblem;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/13 17:32
 */
public class Q50_Pow {
    // 快速幂
    public double myPow(double x, int nn) {
        boolean isNeg = nn < 0;
        long n = nn;
        if(isNeg) {
            n = -n;
        }
        double ans = 1;
        while(n > 0) {
            if((n & 1) == 1) {
                ans *= x;
            }
            n >>= 1;
            x *= x;
        }
        return isNeg ? 1 / ans : ans;
    }
}
