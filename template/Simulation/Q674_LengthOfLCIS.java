package leetcode.template.Simulation;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/24 0:12
 */
public class Q674_LengthOfLCIS {
    // 模拟
    public int findLengthOfLCIS(int[] nums) {
        int l, r, n;
        n = nums.length;
        if(n == 0) {
            return 0;
        }
        l = r = 0;
        int len = 1;
        for(int i = 0; i < n; i++) {
            if(i < n - 1 && nums[i] < nums[i + 1]) {
                continue;
            }
            r = i;
            //
            if(r - l + 1 > len) {
                len = r - l + 1;
            }
            l = r + 1;
        }
        return len;
    }
    public int findLengthOfLCIS1(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }

}
