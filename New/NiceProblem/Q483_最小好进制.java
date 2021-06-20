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


    // 二项式定理 不等式 枚举
    public String smallestGoodBase1(String m) {
        // (11...11)k = k^{s} + k^{s-1} + ... + k^1 + k^0 = n
        // k^s < n < (k+1)^s
        // k < n^{1/s} < k+1
        long n = Long.parseLong(m);
        long ans = n - 1;   // 将答案置为 s=1 的情况
        for (int s = 59; s >= 2; --s) {
            int k = (int)Math.pow(n, 1.0 / s);   // k 为 n^{1/s} 的整数部分
            // System.out.println(k);
            if (k > 1) {    // 判断 k 是否是一个合法的进制
                // 秦九韶算法
                long sum = 1;
                for (int i = 0; i < s; ++i) {
                    sum = sum * k + 1;
                }
                if (sum == n) {
                    ans = k;
                    break;
                }
            }
        }
        return String.valueOf(ans);
    }
    public static void main(String[] args) {
        System.out.println((1.0 / 3));
    }
}
