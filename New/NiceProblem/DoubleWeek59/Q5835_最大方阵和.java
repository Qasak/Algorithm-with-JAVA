package leetcode.contest.DoubleWeek59;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/23 10:18
 */
public class Q5835_最大方阵和 {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int cnt = 0;
        int min = 0x3f3f3f3f;
        long ret = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] < 0) {
                    cnt++;
                    matrix[i][j] = -matrix[i][j];
                }
                if(matrix[i][j] < min) {
                    min = matrix[i][j];
                }
                ret += matrix[i][j];
            }
        }
        if(cnt % 2 == 1) {
            ret -= 2 * min;
        }
        return ret;
    }
}
