package leetcode.contest.NiceProblem;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/10 17:29
 */
public class Q416_分割等和子集 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[] f = new boolean[target + 1];
        f[0] = true;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = target; j >= nums[i]; j--) {
                f[j] |= f[j - nums[i]];
            }
        }
        return f[target];
    }
}
