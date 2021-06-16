package leetcode.contest.NiceProblem;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/16 17:25
 */
public class Q378_有序矩阵中第k小的元素 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0];
        int r = matrix[n - 1][n - 1];
        while(l < r) {
            int m = (l + r) >>> 1;
            // check 函数 检查值m是否是第k大或更大元素
            if(check(matrix, m, k)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    boolean check(int[][] matrix, int m, int k) {
        // num: m是第几个元素
        int num = 0;
        int n = matrix.length;
        // 从最小的列，最大的行开始
        int i = n - 1, j = 0;
        while(i >= 0 && j < n) {
            if(matrix[i][j] <= m) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }
}
