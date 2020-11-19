class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if(n == 0) {
            return false;
        }
        int m = matrix[0].length;
        // 左下角：该列的最大值，该行的最小值

        int i = n - 1, j = 0;
        while(i >= 0 && j <= m - 1) {
            // 该行最小的都比target大，换上一行
            if(matrix[i][j] > target) {
                i--;
            // 该列最大的都比target小，换下一列
            } else if(matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}