package leetcode.contest.NiceProblem.二分应用;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/12 8:46
 */
public class Q1011_在D天内送达包裹的能力 {
    public int shipWithinDays(int[] weights, int days) {
        // 货物必须按照给定的顺序装运
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();
        while(l < r) {
            // 当前的最低运载能力
            int x = (l + r) >>> 1;
            // 当前运载能力不满足
            if(!check(x, weights, days)) {
                l = x + 1;
            } else {
                r = x;
            }
        }
        return l;
    }
    // 可以运送
    private boolean check(int x, int[] weights, int days) {
        int curDays = 1;
        int curWeight = 0;
        for(int w : weights) {
            curWeight += w;
            if(curWeight > x) {
                curDays++;
                curWeight = w;
            }
        }
        return curDays <= days;
    }
}
