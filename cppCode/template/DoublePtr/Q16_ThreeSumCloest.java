package leetcode.template.DoublePtr;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/26 13:24
 */
public class Q16_ThreeSumCloest {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0x3f3f3f3f;
        // -4 -1 1 2
        for(int i = 0; i < n; i++) {
            int r = n - 1;
            for(int l = i + 1; l < n; l++) {
                while(l < r && nums[i] + nums[l] + nums[r] > target) {
                    if(Math.abs(nums[i] + nums[l] + nums[r] - target) < Math.abs(ans - target)) {
                        ans = nums[i] + nums[l] + nums[r];
                    }
                    r--;
                }
                if(l == r ) {
                    break;
                }
                if(Math.abs(nums[i] + nums[l] + nums[r] - target) <= Math.abs(ans - target)) {
                    if(nums[i] + nums[l] + nums[r] == target) {
                        return target;
                    }
                    ans = nums[i] + nums[l] + nums[r];
                }
            }
        }
        return ans;
    }
}
