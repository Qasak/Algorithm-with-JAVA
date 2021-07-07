package leetcode.contest.NiceProblem.前缀和技巧;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/28 23:48
 */
public class Q930_和相同的二元子数组 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int pre = 0;
        int ans = 0;
        map.put(0, 1);
        for(int i = 0; i < n; i++) {
            pre += nums[i];
            if(map.containsKey(pre - goal)) {
                ans += map.get(pre - goal);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }
}
