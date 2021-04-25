package leetcode.SpringRecruit.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/1 12:13
 */
public class Q85_最大矩形 {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if(n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        if(m == 0) {
            return 0;
        }
        // i, j 位置的最大高度
        int[][] dp = new int[n][m];
        for(int j = 0; j < m; j++) {
            if(matrix[0][j] == '1') {
                dp[0][j] = 1;
            }
        }
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == '1') {
                    dp[i][j] = dp[i - 1][j] + 1;
                }
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++) {
            // 3 1 3 2 2
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == '1') {
                    int h = dp[i][j];
                    // 从j点开始时倒着走
                    for(int w = 1; w <= j + 1; w++) {
                        h = Math.min(h, dp[i][j - w + 1]);
                        max = Math.max(max, h * w);
                    }
                }
            }
        }
        // for(int i = 0; i < n; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        return max;
    }

    public static void main(String[] args) {
        // 350,000,000,000
        // 2,147,483,647
        int a = (int) ((int) 3.5 * 1e12);
        System.out.println(a);
    }
    // 2. 单调栈
}
