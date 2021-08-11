package Mitsuha.序列DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/11 18:04
 */
public class Q1035_不相交的线 {
    // f[i][j] 代表考虑 s1s1 的前 ii 个字符、考虑 s2s2 的前 jj 的字符，形成的最长公共子序列长度。
    //
    //然后不失一般性的考虑 f[i][j]f[i][j] 如何转移。
    //
    //由于我们的「状态定义」只是说「考虑前 ii 个和考虑前 jj 个字符」，并没有说「一定要包含第 ii 个或者第 jj 个字符」（这也是「最长公共子序列 LCS」与「最长上升子序列 LIS」状态定义上的最大不同）。
    // 也就是所谓的第i个和前i个的区别
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
