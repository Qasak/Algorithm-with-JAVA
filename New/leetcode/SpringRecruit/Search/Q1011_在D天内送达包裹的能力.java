package leetcode.SpringRecruit.Search;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/26 10:52
 */
public class Q1011_在D天内送达包裹的能力 {
    public int shipWithinDays(int[] weights, int D) {
        // 1. 划分区间
        // 2. 遍历所有划分出的区间方案, 求最小的最大区间值
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();
        int n = weights.length;
        // int[] pre = new int[n + 1];
        // for(int i = 0; i < n; i++) {
        //     pre[i + 1] = pre[i] + weights[i];
        // }
        int target = l;
        // 最大区间：n - D + 1

        // 给定船的运载能力 x，我们是否可以在 D 天内运送完所有包裹
        // 需要的天数need

        // x的取值范围[l, r)
        // 但是最后一次l = x + 1, l可以取到r
        // 即 l的取值范围[l, r]
        while(l < r) {
            int x = (l + r) >>> 1;
            // 当前船运载的重量
            int cur = 0;
            // 需要几辆船(天数)
            int cnt = 1;
            for(int i : weights) {
                // 超过运载能力，用下一辆船装货物i
                cur += i;
                if(cur > x) {
                    cnt++;
                    cur = i;
                }
            }
            // 天数太多， 单次运载量不够
            if(cnt > D) {
                l = x + 1;
            } else {
                r = x;
            }
        }
        return l;
    }
}
