package leetcode.template.Intervals;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/31 11:38
 */
public class Q435_EraseOverlapIntervals {
    // dp
    // 「选出最多数量的区间，使得它们互不重叠」
    // 令 fi
    //  表示「以区间 i 为最后一个区间，可以选出的区间数量的最大值」
    public int eraseOverlapIntervals(int[][] intervals) {
        int n =  intervals.length;
        if(n < 2) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (intervals[j][1] <= intervals[i][0]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return n - Arrays.stream(f).max().getAsInt();

    }
    // greedy
    public int eraseOverlapIntervals1(int[][] intervals) {
        int n =  intervals.length;
        if(n < 2) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int right = intervals[0][1];
        int cnt = 1;
        // 维护一个最左区间
        for (int i = 1; i < n; ++i) {
            // 当前区间左界>=最左区间右界：区间不重叠，选择该区间作为最新的最左区间
            if (right <= intervals[i][0]) {
                cnt++;
                right = intervals[i][1];
            }
        }
        // 总数-最多的区间数=最少的移除数
        return n - cnt;
    }
    public int eraseOverlapIntervals2(int[][] intervals) {
        int n =  intervals.length;
        if(n < 2) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int right = intervals[0][1];
        int ans = 0;
        for (int i = 1; i < n; ++i) {
            // 移除最近的重叠区间
            if (intervals[i][0] < right) {
                ++ans;
            } else {
                right = intervals[i][1];
            }
        }
        return ans;
    }
}
