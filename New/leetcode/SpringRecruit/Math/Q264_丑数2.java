package leetcode.SpringRecruit.Math;

import java.util.TreeSet;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/10 11:25
 */
public class Q264_丑数2 {
    // 编写一个程序，找出第 n 个丑数。
    // 1. TreeSet
    public int nthUglyNumber(int n) {
        TreeSet<Long> tset = new TreeSet<>();
        int[] nums = new int[]{2, 3, 5};
        tset.add(1L);
        for(int i = 0; i < n - 1; i++) {
            for(int j : nums) {
                tset.add(tset.first() * j);
            }
            tset.remove(tset.first());
        }
        return tset.first().intValue();
    }

    // 2. DP
    // 当前的p2,p3,p5三个指针，它们所指向的丑数再乘以其各自对应的因数（即2，3，5），
    // 所得到的三个乘数必定是大于当前数组的最大丑数的；
    public int nthUglyNumber1(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for(int i = 2; i <= n; i++) {
            int num = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3), dp[p5] * 5);
            if(num == dp[p2] * 2) {
                p2++;
            }if(num == dp[p3] * 3) {
                p3++;
            }if(num == dp[p5] * 5) {
                p5++;
            }
            dp[i] = num;
        }
        return dp[n];
    }
    // 丑数就是质因数只包含 2, 3, 5 的正整数。
    public static void main(String[] args) {
        Long a = 3L;
    }
}
