package leetcode.SpringRecruit.Greedy;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/6 20:57
 */
public class Q55_跳跃游戏 {
    class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int r = 0;
            for(int i = 0; i < n; i++) {
                if(r < i) {
                    return false;
                }
                r = Math.max(r, i + nums[i]);
            }
            return true;
        }
    }
}
