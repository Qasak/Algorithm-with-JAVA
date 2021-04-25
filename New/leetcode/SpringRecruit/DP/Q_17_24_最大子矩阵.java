package leetcode.SpringRecruit.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/12 11:15
 */
public class Q_17_24_最大子矩阵 {
    /*
[
    [9,-8,1,3,-2],
    [-3,7,6,-2,4],
    [6,-4,-4,8,-7]

]
*/
    // 前缀和 + 最大连续子序列
    public int[] getMaxMatrix(int[][] matrix) {
        int max = -0x3f3f3f3f;
        int[] ans = new int[4];
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] pre = new int[n + 1][m + 1];
        for(int i = 0 ; i < n; i++) {
            for(int j = 0 ; j < m; j++) {
                pre[i + 1][j + 1] = pre[i][j + 1] + pre[i + 1][j] + matrix[i][j] - pre[i][j];
            }
        }

        for(int x1 = 0; x1 < n; x1++) {
            for(int x2 = x1; x2 < n; x2++) {
                int y1 = 0;
                int dp = 0;
                for(int y2 = 0; y2 < m; y2++) {
                    // 一个竖条
                    int cur = getArea(pre, x1, y2, x2, y2);
                    // 新开一个子序列
                    if(dp + cur < cur) {
                        y1 = y2;
                        dp = cur;
                    } else {
                        dp = dp + cur;
                    }
                    if(dp > max) {
                        max = dp;
                        ans[0] = x1; ans[1] = y1; ans[2] = x2; ans[3] = y2;
                    }

                }
            }
        }
        return ans;
    }
    // 输入下标
    public int getArea(int[][] pre, int x1, int y1, int x2, int y2) {
        return pre[x2 + 1][y2 + 1] - pre[x2 + 1][y1] - pre[x1][y2 + 1] + pre[x1][y1];
    }

}
