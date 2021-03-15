package leetcode.template.Greedy;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/7 17:53
 */
public class Q252_会议室 {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int n = intervals.length;
        if(n == 0) {
            return true;
        }
        int l = intervals[0][0];
        int r = intervals[0][1];
        for(int i = 1; i < n; i++) {
            if(intervals[i][0] < r) {
                return false;
            }
            r = intervals[i][1];
        }
        return true;
    }
}
