package leetcode.template.DP.Rectangle;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/18 16:47
 */
public class Q85_MaxRectangle {
    // dp1
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if(n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        if(m == 0) {
            return 0;
        }
        int[][][] dp = new int[n][m][2];
        // dp[i][j][0] :宽度
        dp[0][0][0] = dp[0][0][1] = matrix[0][0] == '1' ? 1:0;
        int mxSize = dp[0][0][0];
        for(int i = 1; i < n; i++) {
            if(matrix[i][0] == '1') {
                dp[i][0][1] = 1;
                dp[i][0][0] = dp[i - 1][0][0] + 1;
            }
            mxSize = Math.max(mxSize, dp[i][0][0]);
        }
        for(int j = 1; j < m; j++) {
            if(matrix[0][j] == '1') {
                dp[0][j][0] = 1;
                dp[0][j][1] = dp[0][j - 1][1] + 1;
            }
            mxSize = Math.max(mxSize, dp[0][j][1]);
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(matrix[i][j] == '1') {
                    dp[i][j][0] = dp[i - 1][j][0] + 1;
                    dp[i][j][1] = dp[i][j - 1][1] + 1;
                    // 当前长度的最大矩形面积height * length
                    // 往左扫描length长度，
                    int minHeight = dp[i][j][0], length = dp[i][j][1];
                    for (int k = j; k >= j - length + 1; k--) {
                        minHeight = Math.min(minHeight, dp[i][k][0]);
                        mxSize=Math.max(mxSize, (j - k + 1) * minHeight);
                    }
                }
            }
        }
        return mxSize;
    }
    // dp2
    public int maximalRectangle2(char[][] matrix) {
        int n = matrix.length;
        if(n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        if(m == 0) {
            return 0;
        }
        int mxSize = 0;
        // （i,j）处的最大长度
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == '1') {
                    if(j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i][j - 1] + 1;
                    }
                    int minLen = dp[i][j];
                    // 往上扫描
                    for(int k = i; k >= 0; k--) {
                        minLen = Math.min(minLen, dp[k][j]);
                        mxSize = Math.max(mxSize, minLen * (i - k + 1));
                    }
                }
            }
        }
        return mxSize;
    }
    // dp3
    public int maximalRectangle3(char[][] matrix) {
        int n = matrix.length;
        if(n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        if(m == 0) {
            return 0;
        }
        int mxSize = 0;
        // (i, j )处的最大高度
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == '1') {
                    if(i == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j] + 1;
                    }
                    int h = dp[i][j];
                    //w : [1, 5]
                    // 2 x 1/ 2 x 2/ 2 x 3/ 1 x 4/ 1 x 5
                    for(int w = 1; w <= j + 1; w++) {
                        // [4, 0]
                        // j = 4
                        // w = 5
                        h = Math.min(h, dp[i][j - w + 1]);
                        mxSize = Math.max(mxSize, h * w);
                    }
                }
            }
        }
        return mxSize;
    }
    // dp4
    public int maximalRectangle4(char[][] matrix) {
        int n = matrix.length;
        if(n == 0){
            return 0;
        }
        int m = matrix[0].length;
        if(m == 0) {
            return 0;
        }
        // 5 x 1/ 3 x 2/
        // dp[i][j] : 第i行第j列的最大长度
        int ans = 0;
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == '1') {
                    if(j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i][j - 1] + 1;
                    }
                } // 0
                int w = dp[i][j];
                // [1,3]
                for(int h = 1; h <= i + 1; h++) {
                    // 2 - 1 + 1 = 2
                    // 2 - 3 + 1 = 0
                    w = Math.min(w, dp[i - h + 1][j]);
                    ans = Math.max(ans, w * h);
                }
            }
        }
        return ans;
    }
    //单调栈
    public int maximalRectangle5(char[][] matrix) {
        int n = matrix.length;
        if(n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        if(m == 0) {
            return 0;
        }
        int ans = 0;
        int[][] arr = new int[n][m + 2];
        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= m; j++) {
                if(matrix[i][j - 1] == '1') {
                    if(i == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j] + 1;
                    }
                }
            }
        }
        Deque<Integer> s = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= m + 1; j++) {

                while(!s.isEmpty() && arr[i][j] < arr[i][s.peek()] ) {
                    int h = arr[i][s.pop()];
                    int r = j;
                    int l = s.peek();
                    ans = Math.max(ans, h * (r - l - 1));
                }
                s.push(j);
            }
        }
        return ans;
    }
}
