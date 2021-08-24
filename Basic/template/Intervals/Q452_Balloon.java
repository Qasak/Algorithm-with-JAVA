package leetcode.template.Intervals;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/31 12:23
 */
public class Q452_Balloon {
    public int findMinArrowShots(int[][] points) {
        /**
         **/
        if(points.length < 1) {
            return 0;
        }
        // [[-2147483646,-2147483645],[2147483646,2147483647]]
        Arrays.sort(points, (a, b) -> (Integer.compare(a[1], b[1])));
        int cnt = 1;
        int r = points[0][1];
        // 维护一个最左区间
        // 最多不相交区间数=至少需要射箭数
        for(int i = 1; i < points.length; ++i) {
            // 当前区间左界> 最左区间右界，射一发，当前区间作新的最左区间
            if(r < points[i][0]) {
                cnt++;
                r = points[i][1];
            }
            // else 所有左界<=最左区间右界的气球，以一发解决
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(Integer.compare(2, 33336));
    }
}
