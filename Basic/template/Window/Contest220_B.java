package leetcode.template.Window;

import java.util.HashSet;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/20 12:10
 *
 * [5,2,1,2,5,2,1,2,5]
 *
 */
public class Contest220_B {
    public static int maximumUniqueSubarray(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int[] pre = new int[n + 1];
        for(int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }

        HashSet<Integer> set = new HashSet<>();
        int l = 0;
        for(int i = 0; i < n; i++) {
            while(set.contains(nums[i])) {
                set.remove(nums[l]);
                l++;
            }
            ans = Math.max(ans, pre[i + 1] - pre[l]);
            set.add(nums[i]);
        }
        return ans;
    }
}
