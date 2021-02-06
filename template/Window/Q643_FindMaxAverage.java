package leetcode.template.Window;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/4 0:00
 */
public class Q643_FindMaxAverage {
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int n = nums.length;
            int sum = 0;
            int ans = 0;
            // [[1,12,-5,-6],50,3]
            for(int i = 0; i < k; i++) {
                sum += nums[i];
            }
            ans = sum;
            for(int l = 0, r = k; r < n; l++, r++) {
                sum += nums[r]; sum -= nums[l];
                ans = Math.max(ans, sum);
            }
            return ans * 1.0 / k;
        }
    }
}
