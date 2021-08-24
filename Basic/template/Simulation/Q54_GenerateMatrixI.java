package leetcode.template.Simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/1 12:09
 */
public class Q54_GenerateMatrixI {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int l = 0, r = m - 1, u = 0, b = n - 1;
        for(int cnt = 0; cnt < n * m; ) {
            for(int i = l; i <= r; i++) {
                ans.add(matrix[u][i]);
                cnt++;
            }
            u++;
            if(cnt == n * m) {
                break;
            }
            for(int i = u; i <= b; i++) {
                ans.add(matrix[i][r]);
                cnt++;
            }
            r--;
            if(cnt == n * m) {
                break;
            }
            for(int i = r; i >= l; i--) {
                ans.add(matrix[b][i]);
                cnt++;
            }
            b--;
            if(cnt == n * m) {
                break;
            }
            for(int i = b; i >= u; i--) {
                ans.add(matrix[i][l]);
                cnt++;
            }
            l++;
            if(cnt == n * m) {
                break;
            }
        }
        return ans;
    }
}
