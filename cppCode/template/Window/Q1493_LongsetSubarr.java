package leetcode.template.Window;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/2 16:54
 */
public class Q1493_LongsetSubarr {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int l = 0;
        int cnt = 0;
        int ans = 0;
        for(int r = 0; r < n; r++) {
            if(nums[r] == 0) {
                cnt++;
            }
            while(cnt == 2) {
                if(nums[l++] == 0) {
                    cnt--;
                    break;
                }
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans - 1;
    }
}
