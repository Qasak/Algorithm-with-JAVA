package leetcode.template.BinCalc;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/22 14:04
 */
public class Q762_二进制中质数个计算置位 {
    boolean[] flag = new boolean[33];
    public int countPrimeSetBits(int L, int R) {
        int ans = 0;
        Arrays.fill(flag, true);
        eratosthenes(32);
        for(int i = L; i <= R; i++) {
            if(flag[Integer.bitCount(i)]) {
                ans++;
            }
        }
        return ans;
    }
    public void eratosthenes(int n) {
        flag[0] = flag[1] = false;
        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (flag[i]) {
                for (int j = i * i; j <= n; j += i) {
                    flag[j] = false;
                }
            }
        }
    }
}
