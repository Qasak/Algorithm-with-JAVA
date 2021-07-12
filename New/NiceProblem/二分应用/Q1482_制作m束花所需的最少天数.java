package leetcode.contest.NiceProblem.二分应用;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/12 9:21
 */
public class Q1482_制作m束花所需的最少天数 {
// 这个制作花束的人是个笨比，只会拿连续的花。
// 因此可以用贪心的方法来拿花，并且遵顼以下的策略：
// 每次遍历花园中的花：

    // 遇到开花的花，就拿在手上
// 遇到没开的花，就把手上的花全部扔掉
// 手上的花足够制作花束，就制作花束，制作完后放到一旁（此时手上没花了）
    public int minDays(int[] bloomDay, int m, int k) {
        int cnt = m * k;
        int n = bloomDay.length;
        if(n < cnt) {
            return -1;
        }
        int l = Arrays.stream(bloomDay).min().getAsInt();
        int r = Arrays.stream(bloomDay).max().getAsInt();
        while(l < r) {
            int d = (l + r) >>> 1;
            if(!check(d, bloomDay, n, m, k)) {
                l = d + 1;
            } else {
                r = d;
            }
        }
        return l;
    }
    // 是否有m个长度为k，每个元素都 <= d的连续子数组

    // 贪心
    private boolean check(int d, int[] bloomDay, int n, int m, int k) {
        int cnt = 0;
        int flower = 0;
        for(int day : bloomDay) {
            if(day <= d) {
                flower++;
            } else {
                flower = 0;
            }
            if(flower == k) {
                cnt++;
                flower = 0;
            }
        }
        return cnt >= m;
    }
}
