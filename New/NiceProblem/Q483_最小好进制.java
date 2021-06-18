package leetcode.contest.NiceProblem;
import java.math.BigInteger;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/18 8:46
 */
public class Q483_最小好进制 {
    public String smallestGoodBase(String n) {
        BigInteger num = new BigInteger(String.valueOf(n));
        long ans = Long.MAX_VALUE;
        for(int i = 2; i <= 64; i++) {
            long l = 2, r = num.longValue();
            while(l < r) {
                long m = (l + r) >>> 1;
                BigInteger tmp = check(m, i);
                if(tmp.equals(num)) {
                    ans = Math.min(ans, m);
                    break;
                }
                else if(tmp.compareTo(num) > 0) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
        }
        return String.valueOf(ans);
    }

    // m进制, x位
    private BigInteger check(long m, int x) {
        BigInteger res = new BigInteger(String.valueOf(0));
        BigInteger M = new BigInteger(String.valueOf(m));
        BigInteger one = new BigInteger(String.valueOf(1));
        for(int i = 0; i < x; i++) {
            res = res.multiply(M).add(one);
        }
        return res;
    }
}
