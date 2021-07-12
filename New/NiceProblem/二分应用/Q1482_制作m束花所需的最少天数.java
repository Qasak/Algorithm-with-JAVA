package leetcode.contest.NiceProblem.二分应用;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/12 9:21
 */
public class Q1482_制作m束花所需的最少天数 {
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
        for(int i = 0; i < n; i++) {
            if(bloomDay[i] <= d) {
                flower++;
                if(flower == k) {
                    cnt++;
                    flower = 0;
                }
            } else {
                flower = 0;
            }
        }
        return cnt >= m;
    }
}
