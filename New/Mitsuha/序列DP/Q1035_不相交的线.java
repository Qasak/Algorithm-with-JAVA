package Mitsuha.序列DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/11 18:04
 */
public class Q1035_不相交的线 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        // f[i][j] : nums1[0, i] 和 nums2[0, j] 子序列的最大连线数
        int[][] f = new int[n + 1][m + 1];
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                if(nums1[i - 1] == nums2[j - 1]) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        return f[n][m];
    }
}
