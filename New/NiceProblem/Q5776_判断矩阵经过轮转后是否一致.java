package leetcode.contest.NiceProblem;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/6 20:02
 */
public class Q5776_判断矩阵经过轮转后是否一致 {
    public boolean findRotation(int[][] mat, int[][] target) {

        int n = mat.length;
        for(int i = 0; i < 4; i++) {
            // 深拷贝相同
            if(Arrays.deepEquals(mat, target)) {
                return true;
            } else {
                // for(int j = 0; j < n; j++) {
                //     System.out.println(Arrays.toString(mat[j]));
                // }
                // System.out.println();
                rotate(mat);
            }
        }
        return false;
    }
    public void rotate(int[][] mat) {
        int n = mat.length;
        int[][] tmp = new int[n][n];
        for(int i = 0 ; i < n; i++) {
            for(int j = 0; j < n; j++) {
                tmp[i][j] = mat[i][j];
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                mat[i][j] = tmp[j][n - 1 - i];
            }
        }
    }
}
