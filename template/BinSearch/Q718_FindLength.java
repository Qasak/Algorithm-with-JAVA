package leetcode.template.BinSearch;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/4 21:27
 *
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 */
public class Q718_FindLength {
    // LCString
    public int findLength(int[] A, int[] B) {
        int ans = 0;
        int n = A.length;
        int m = B.length;

        // dp[i][j] : A的前缀子数组A[0..i]和B的前缀子数组B[0...j]的最长公共子数组长度
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
    // Window
    public int findLength1(int[] A, int[] B) {
        int ans = 0;
        int n = A.length;
        int m = B.length;
        // A的起点:[0, n - 1]
        for(int i = 0; i < n; i++) {
            // B与A相交数组的长度
            int len = Math.min(m, n - i);
            int t = findInner(A, B, i, 0, len);
            ans = Math.max(ans, t);
        }
        for(int i = 0; i < m; i++) {
            // B与A相交的长度
            int len = Math.min(n, m - i);
            int t = findInner(A, B, 0, i, len);
            ans = Math.max(ans, t);
        }
        return ans;
    }
    private int findInner(int[] A, int[] B, int startA, int startB, int len) {
        int k = 0;
        int maxK = 0;
        for(int i = 0; i < len; i++) {
            if(A[i + startA] == B[i + startB]) {
                k++;
                maxK = Math.max(k, maxK);
            } else {
                k = 0;
            }
        }
        return maxK;
    }



    // Hash + binSearch
    int mod = 1000000009;
    int base = 113;

    public int findLength2(int[] A, int[] B) {
        int left = 1, right = Math.min(A.length, B.length) + 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(A, B, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

    public boolean check(int[] A, int[] B, int len) {
        long hashA = 0;
        for (int i = 0; i < len; i++) {
            hashA = (hashA * base + A[i]) % mod;
        }
        Set<Long> bucketA = new HashSet<Long>();
        bucketA.add(hashA);
        long mult = qPow(base, len - 1);
        for (int i = len; i < A.length; i++) {
            hashA = ((hashA - A[i - len] * mult % mod + mod) % mod * base + A[i]) % mod;
            bucketA.add(hashA);
        }
        long hashB = 0;
        for (int i = 0; i < len; i++) {
            hashB = (hashB * base + B[i]) % mod;
        }
        if (bucketA.contains(hashB)) {
            return true;
        }
        for (int i = len; i < B.length; i++) {
            hashB = ((hashB - B[i - len] * mult % mod + mod) % mod * base + B[i]) % mod;
            if (bucketA.contains(hashB)) {
                return true;
            }
        }
        return false;
    }

    // 使用快速幂计算 x^n % mod 的值
    public long qPow(long x, long n) {
        long ret = 1;
        while (n != 0) {
            if ((n & 1) != 0) {
                ret = ret * x % mod;
            }
            x = x * x % mod;
            n >>= 1;
        }
        return ret;
    }

}
