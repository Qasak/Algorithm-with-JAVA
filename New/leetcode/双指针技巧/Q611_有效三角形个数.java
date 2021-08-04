package leetcode.contest.NiceProblem.双指针技巧;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/4 11:54
 */
public class Q611_有效三角形个数 {
    class Solution {
        public int triangleNumber(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i - 1, k = 0; k < j; j--) {
                    while (k < j && nums[k] + nums[j] <= nums[i]) k++;
                    ans += j - k;
                }
            }
            return ans;
        }
    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int k = i + 1;
            for(int j = i + 1; j < n; j++) {
                while(k < n && nums[i] + nums[k] <= nums[j] ) {
                    k++;
                }
                if(k < j)
                    ans += j - k;
            }
        }
        return ans;
    }
}
