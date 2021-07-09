package leetcode.contest.Week_236;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/9 16:29
 */
public class Q1828_统计一个圆中点的数目 {
    // 暴力枚举
    public int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            int x = queries[i][0], y = queries[i][1], r = queries[i][2];
            for(int j = 0; j < points.length; j++) {
                int a = points[j][0], b = points[j][1];
                if(Math.sqrt(Math.abs(x - a) * Math.abs(x - a) +
                        Math.abs(y - b) * Math.abs(y - b)) <= r) {
                    cnt++;
                }
            }
            ans[i] = cnt;
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}
