package leetcode.template.Hash;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/1 2:23
 */
public class Q16_14_BestLine {
    // brute
    public int[] bestLine(int[][] points) {
        int n = points.length;
        int max = 0;
        int [] ans = new int[]{0,1};
        // Arrays.sort(points, (a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                int cnt = 0;
                double k = (double)(points[j][1] - points[i][1]) / (points[j][0] - points[i][0]) ;
                for(int p = 0; p < n; p++) {
                    if(p != i && p != j) {
                        double k1 = (double)(points[p][1] - points[i][1]) / (points[p][0] - points[i][0]);
                        if(k == k1 || (Double.isInfinite(k) && Double.isInfinite(k1))) {
                            cnt++;
                        }
                    }
                }
                if(cnt > max) {
                    max = cnt;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        return ans;
    }
    // HashMap
}
