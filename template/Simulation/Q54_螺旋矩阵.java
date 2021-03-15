package leetcode.template.Simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/5 11:23
 */
public class Q54_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        if(n == 0) {
            return ans;
        }
        int m = matrix[0].length;
        if(m == 0) {
            return ans;
        }
        int u = 0, d = n - 1, l = 0, r = m - 1;
        int cnt = 0;
        while(cnt < m * n) {
            for(int i = u, j = l; cnt < m * n && j <= r ; j++) {
                ans.add(matrix[i][j]);
                cnt++;
            }
            u++;
            for(int i = u, j = r; cnt < m * n && i <= d; i++) {
                ans.add(matrix[i][j]);
                cnt++;
            }
            r--;
            for(int i = d, j = r; cnt < m * n && j >= l; j--) {
                ans.add(matrix[i][j]);
                cnt++;
            }
            d--;
            for(int i = d, j = l; cnt < m * n && i >= u; i--) {
                ans.add(matrix[i][j]);
                cnt++;
            }
            l++;
        }
        return ans;
    }
}
