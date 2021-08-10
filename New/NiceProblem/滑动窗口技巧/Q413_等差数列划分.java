package leetcode.NiceProblem.滑动窗口技巧;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/10 13:01
 */
public class Q413_等差数列划分 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n < 3) {
            return 0;
        }
        int ans = 0;
        // 1 2 3 4 5 6 7
        for(int i = 0; i < n - 1; ) {
            int d = nums[i] - nums[i + 1];
            int j = i;
            while(j < n - 1 && nums[j] - nums[j + 1] == d) {
                j++;
            }
            int cnt = j - i;
            if(cnt >= 2) {
                ans += (cnt * (cnt - 1)) / 2;
            }
            i = j;
        }
        return ans;
    }
}
