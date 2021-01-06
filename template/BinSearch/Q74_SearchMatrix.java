package leetcode.template.BinSearch;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/6 22:49
 */
public class Q74_SearchMatrix {
    // 贪心
    public boolean searchMatrix(int[][] g, int target) {
        int n = g.length;
        if(n == 0) {
            return false;
        }
        int m = g[0].length;
        int i = n - 1;
        int j = 0;
        while(i >= 0 && j < m) {
            if(target == g[i][j]) {
                return true;
            }
            if(target < g[i][j]) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
    // 二分
    public boolean searchMatrix1(int[][] g, int target) {
        int n = g.length;
        if(n == 0) {
            return false;
        }
        int m = g[0].length;
        int l = 0, r = n * m - 1;
        // 3 * 4
        // [0, 11]
        // mid = 11 / 2 = 5
        // g[1][1]

        // 1 * 2
        while(l <= r) {
            int mid = (l + r) >>> 1;
            int v = g[mid / m][mid % m];
            if(v == target) {
                return true;
            }
            if(v < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
