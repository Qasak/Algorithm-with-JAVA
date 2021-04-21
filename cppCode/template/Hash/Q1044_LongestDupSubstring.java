package leetcode.template.Hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/19 15:34
 */
public class Q1044_LongestDupSubstring {
    // 1.二分+Rabin-Karp
    public String longestDupSubstring(String s) {
        // [1, n - 1]
        // banana
        // b
        // a
        // n
        //
        // base = 26
        // l = [1, n - 1]
        //

        // aaaaa

        int n = s.length();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = s.charAt(i) - 'a';
        }
        // 字串长度L的取值范围 [1, n - 1]
        int l = 1, r = n;
        int L = 1;
        int pos = -1;
        int realL = 0;
        int realPos = -1;
        while(l < r) {
            L = (l + r) >>> 1;
            pos = search(nums, L);
            // 找到了长度为L的子串，那么肯定有长度>=L的子串
            if(pos != -1) {
                if(L > realL) {
                    realL = L;
                    realPos = pos;
                }
                l = L + 1;
            } else {
                r = L;
            }
        }
        //
        return realPos == -1 ? "" : s.substring(realPos, realPos + realL);
    }
    private int search(int[] nums, int L) {
        long mod = 100000000007L;
        int n = nums.length;
        int base = 26;
        long hi = 1;
        for(int i = 0; i < L; i++) {
            hi = (hi * base) % mod;
        }
        long h = 0;
        Set<Long> set = new HashSet<>();
        for(int i = 0; i < L; i++) {
            h = (h * base + nums[i]) % mod;
        }
        set.add(h);
        for(int i = 1; i <= n - L; i++) {
            // (a + b) % p = (a % p + b % p) % p
//            h = (h * base - nums[i - 1] * hi % mod + mod) % mod;
//            h = (h + nums[i + L - 1]) % mod;
            // h = (h * base - nums[i - 1] * hi + nums[i + L - 1]) % mod;

            h = ((h * base % mod - nums[i - 1] * hi % mod + mod) % mod + nums[i + L - 1] % mod) % mod;

            if(!set.add(h)) {
                return i;
            }
        }
        return -1;
    }


    // 2. 后缀数组



}
