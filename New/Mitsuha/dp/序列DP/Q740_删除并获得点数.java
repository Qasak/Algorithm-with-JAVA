package Mitsuha.序列DP;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/11 15:47
 */
public class Q740_删除并获得点数 {
    // 「序列 DP」问题（选择某个数，需要考虑前一个数的「大小/选择」状态）
    public int deleteAndEarn(int[] nums) {
        // f[i][0] 不选数值为i的数字的最大点数
        // f[i][1] 选数值为i的数字的最大点数
        int n = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        int[][] f = new int[max + 1][2];
        int[] cnt = new int[max + 1];
        for(int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        // 遍历数值
        for(int i = 1; i <= max; i++) {
            f[i][1] = i * cnt[i] + f[i - 1][0];
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
        }
        return Math.max(f[max][0], f[max][1]);
    }
}
