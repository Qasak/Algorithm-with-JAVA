package leetcode.contest.Rating2000.数学;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/18 21:01
 */
public class Q1969_数组元素的最小非零乘积 {
    // py3
    //         return ((1 << p) - 1) * pow(((1 << p) - 2), ((1 << (p - 1)) - 1), 1000000007) % 1000000007
    long mod = (long) 1e9 + 7;
    public int minNonZeroProduct(int p) {
        long a = ((1L << p) - 1L);
        long b = ((1L << p) - 2L);
        long c = ((1L << (p - 1L)) - 1);
        return (int)(((a % mod) * (pow(b, c) % mod)) % mod);
    }
    int pow(long a, long p) {
        long ans = 1;
        while(p != 0) {
            if((p & 1) == 1) {
                ans = ((ans % mod) * (a % mod)) % mod;
            }
            a = ((a % mod) * (a % mod)) % mod;
            p >>= 1;
        }
        return (int)(ans % mod);
    }
}
