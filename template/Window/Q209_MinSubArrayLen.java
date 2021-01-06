package leetcode.template.Window;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/4 17:22
 */
public class Q209_MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        int ans = 0x3f3f3f3f;
        int i = 0, j = 0;
        int sum = 0;
        while(j < n) {
            sum += nums[j];
            while(sum >= s) {
                ans = Math.min(ans, j - i + 1);
                sum -= nums[i++];
            }
            j++;
        }
        // 2,3,1,2,4,3
        // 正整数
        // 1,9,1,1 s = 9

        return ans == 0x3f3f3f3f ? 0 : ans;
    }
}
