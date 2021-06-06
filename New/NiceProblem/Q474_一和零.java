package leetcode.contest.NiceProblem;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/6 15:08
 */
public class Q474_一和零 {
    // 二位零一背包
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] nums = new int[len][2];
        for(int i = 0; i < len; i++) {
            nums[i][0] = getZeros(strs[i]);
            nums[i][1] = getOnes(strs[i]);
        }
        // f[j][k] : 容量为 j,k 时的最大子集
        int[][] f = new int[m + 1][n + 1];
        for(int i = 0; i < len; i++) {
            for(int j = m; j >= nums[i][0]; j--) {
                for(int k = n; k >= nums[i][1]; k--) {
                    f[j][k] = Math.max(f[j][k], f[j - nums[i][0]][k - nums[i][1]] + 1);
                }
            }
        }
        return f[m][n];
    }
    public int getOnes(String s) {
        int res = 0;
        for(char c : s.toCharArray()) {
            if(c == '1') {
                res++;
            }
        }
        return res;
    }
    public int getZeros(String s) {
        int res = 0;
        for(char c : s.toCharArray()) {
            if(c == '0') {
                res++;
            }
        }
        return res;
    }
}
