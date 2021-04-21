package leetcode.SpringRecruit.Search;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/30 8:53
 */
public class Q74_搜索二维矩阵 {
    int n;
    int m;
    public boolean searchMatrix(int[][] matrix, int target) {
        n = matrix.length;
        m = matrix[0].length;
        return dfs(matrix, 0, m - 1,target);
    }
    public boolean dfs(int[][] matrix, int i, int j, int target) {
        if(i == n || j == -1) {
            return false;
        }
        int cur = matrix[i][j];
        if(target == cur) {
            return true;
        } else if(cur > target) {
            return dfs(matrix, i, j - 1, target);
        } else {
            return dfs(matrix, i + 1, j, target);
        }
    }


    public boolean searchMatrix1(int[][] matrix, int target) {
        return lowerBound(matrix, target);
    }
    public boolean lowerBound(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0, r = m * n - 1;
        while(l < r) {
            int mid = (l + r) >>> 1;
            int cur = matrix[mid / m][mid % m];
            if(cur < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return matrix[l / m][l % m] == target;
    }
}
