package leetcode.template.PrefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/7 17:13
 */
public class Q560_SubArraySum {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        int n = nums.length;
        map.put(0, 1);
        int sum = 0;
        for(int i = 0; i < n; i++) {
            // System.out.println(sum);
            sum += nums[i];
            // sum = x + k
            if(map.containsKey(sum - k)) {
                cnt += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        // System.out.println(map);
        return cnt;
    }
}
