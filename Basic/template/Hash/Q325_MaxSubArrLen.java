package leetcode.template.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/11 22:58
 */
public class Q325_MaxSubArrLen {
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int ans = 0;
        for(int i = 0 ; i < n; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k)) {
                ans = Math.max(ans, i - map.get(sum - k));
            }
            map.putIfAbsent(sum, i);
        }
        return ans;
    }
}
