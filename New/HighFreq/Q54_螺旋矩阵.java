package leetcode.HighFreq;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/25 22:45
 */
public class Q54_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int u = 0, d = n - 1, l = 0, r = m - 1;
        int i = 0, j = 0;
        while(u <= d && l <= r) {
            // l -> r
            // u--
            while(j <= r) {
                ans.add(matrix[i][j++]);
            }
            j--;
            i++;
            u++;
            if(u > d || l > r) {
                break;
            }
            // u -> d
            // r--
            while(i <= d) {
                ans.add(matrix[i++][j]);
            }
            i--;
            j--;
            r--;
            if(u > d || l > r) {
                break;
            }
            // r -> l
            // d++
            while(j >= l) {
                ans.add(matrix[i][j--]);
            }
            j++;
            i--;
            d--;
            if(u > d || l > r) {
                break;
            }
            // d -> u
            // l++
            while(i >= u) {
                ans.add(matrix[i--][j]);
            }
            i++;
            j++;
            l++;
            if(u > d || l > r) {
                break;
            }
        }
        return ans;
    }
}
