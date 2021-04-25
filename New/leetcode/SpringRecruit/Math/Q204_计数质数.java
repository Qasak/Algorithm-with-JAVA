package leetcode.SpringRecruit.Math;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/10 11:24
 */
public class Q204_计数质数 {
    // 在大于 1的自然数中，除了 1和它本身以外不再有其他因数的自然数
    // 暴力 O(n*√n)
    // 考虑到如果 y 是 x 的因数，那么y/x也必然是 x 的因数
    public int countPrimes(int n) {
        // 12 : 3 * 4
        int ans = 0;
        for(int i = 2; i < n; i++) {
            if(isPrime(i)) {
                ans++;
            }
        }
        return ans;

    }
    public boolean isPrime(int x) {
        for(int i = 2; i * i <= x; i++) {
            if(x % i == 0) {
                return false;
            }
        }
        return true;
    }



    // 筛法
    // x(x + (x + 1) + (x + 2) ....)
    class Solution {
        public int countPrimes(int n) {
            boolean[] isPrime = new boolean[n];
            Arrays.fill(isPrime, true);
            int ans = 0;
            for(int i = 2; i < n; i++) {
                if(isPrime[i]) {
                    ans++;
                    if(i <= n / i) {
                        for(int j = i * i; j < n; j += i) {
                            isPrime[j] = false;
                        }
                    }
                }
            }
            return ans;
        }
    }
}
