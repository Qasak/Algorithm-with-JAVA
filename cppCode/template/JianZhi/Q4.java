package leetcode.JianZhi;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/12 17:07
 */
/*
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

把这个矩阵看成BST
* **/
public class Q4 {
    // 从左下角走
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if(n == 0) {
            return false;
        }
        int m = matrix[0].length;
        int i = n - 1;
        int j = 0;
        while(i >= 0 && j < m) {
            if(matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
    // 从右上角走
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        int n = matrix.length;
        if(n == 0) {
            return false;
        }
        int m = matrix[0].length;
        int i = 0;
        int j = m - 1;
        while(j >= 0 && i < n) {
            if(matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
