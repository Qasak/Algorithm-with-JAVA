package leetcode.contest.NiceProblem;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/24 15:00
 */
public class Q149_直线上最多的点 {
    // 1. 枚举 避免除法
    public int maxPoints(int[][] points) {
        int ans = 1;
        int n = points.length;
        // y = kx + b
        // y1 = kx1 + b;
        // y2 = kx2 + b;
        // y3 = kx3 + b;
        // y1 - y2 = k(x1 - x2)
        // k = (y1 - y2) / (x1 - x2)
        // k' = (y1 - y3) / (x1 - x3)
        // (y1 - y2) * (x1 - x3) == (y1 - y3) * (x1 - x2)
        for(int i = 0; i < n; i++) {
            int[] a = points[i];
            for(int j = i + 1; j < n; j++) {
                int[] b = points[j];
                int cnt = 2;
                for(int k = j + 1; k < n; k++) {
                    int[] c = points[k];
                    int s1 = (a[1] - b[1]) * (a[0] - c[0]);
                    int s2 = (a[1] - c[1]) * (a[0] - b[0]);
                    if(s1 == s2) {
                        cnt++;
                    }
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
    // 2.
}
