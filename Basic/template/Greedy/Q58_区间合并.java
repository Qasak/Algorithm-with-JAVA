package leetcode.template.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/7 17:49
 */
public class Q58_区间合并 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        if(n <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int l = intervals[0][0];
        int r = intervals[0][1];
        int i = 1;
        for(; i < n; ) {
            while(i < n && r >= intervals[i][0]) {
                r = Math.max(r, intervals[i][1]);
                l = Math.min(l, intervals[i][0]);
                i++;
            }
            ans.add(new int[]{l, r});
            if(i < n) {
                l = intervals[i][0];
                r = intervals[i][1];
                i++;
                if(i == n) {
                    ans.add(new int[]{l, r});
                }
            }
        }

        int[][] ret = new int[ans.size()][2];
        int idx = 0;
        for(int[] t : ans) {
            ret[idx][0] = t[0];
            ret[idx][1] = t[1];
            idx++;
        }
        return ret;
    }
}
