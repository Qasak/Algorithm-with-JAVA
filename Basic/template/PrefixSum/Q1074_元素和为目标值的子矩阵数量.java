package leetcode.template.PrefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/5/29 11:29
 */
public class Q1074_元素和为目标值的子矩阵数量 {
    // 暴力前缀和 n ^ 4 (枚举点)
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] pre = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                pre[i + 1][j + 1] = matrix[i][j] + pre[i][j + 1] + pre[i + 1][j] - pre[i][j];
            }
        }
        int ans = 0;
        for(int x1 = 0; x1 < n; x1++) {
            for(int y1 = 0; y1 < m; y1++) {
                for(int x2 = x1; x2 < n; x2++) {
                    for(int y2 = y1; y2 < m; y2++) {
                        if(target == getArea(pre, x1, y1, x2, y2)) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }

    // 枚举边 n ^ 3
    public int numSubmatrixSumTarget1(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] pre = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                pre[i + 1][j + 1] = matrix[i][j] + pre[i][j + 1] + pre[i + 1][j] - pre[i][j];
            }
        }
        int ans = 0;
        for(int r1 = 0; r1 < n; r1++) {
            for(int r2 = r1; r2 < n; r2++) {
                int cur = 0;
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                for(int c = 0; c < m; c++) {
                    cur = getArea(pre, r1, 0, r2, c);
                    ans += map.getOrDefault(cur - target, 0);
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return ans;
    }
    public int getArea(int[][] pre, int x1, int y1, int x2, int y2) {
        return pre[x2 + 1][y2 + 1] - pre[x1][y2 + 1] - pre[x2 + 1][y1] + pre[x1][y1];
    }
}
