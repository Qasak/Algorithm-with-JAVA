package leetcode.JianZhi;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/12 23:22
 */

// 取余之后max函数就不能用来比大小了
public class Q14_1 {
    private final int mod = 1000000007;
    public int cuttingRope(int n) {
        if(n == 2) {
            return 1;
        }
        if(n == 3){
            return 2;
        }
        long res = 1;
        while(n > 4) {
            res *= 3;
            res %= mod;
            n -= 3;
        }
        return (int)(res * n % mod);
    }

    // 大数运算 BigInteger
    public int cuttingRope1(int n) {
        BigInteger dp[] = new BigInteger[n + 1];
        Arrays.fill(dp, BigInteger.valueOf(0));
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = dp[i].max(BigInteger.valueOf(j * (i - j))).max(dp[i - j].multiply(BigInteger.valueOf(j)));
            }
        }
        return  dp[n].mod(BigInteger.valueOf(mod)).intValue();
    }
}
