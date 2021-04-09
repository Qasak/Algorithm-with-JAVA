package leetcode.SpringRecruit.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/22 23:23
 */
public class Q560_和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        map.put(0, 1);
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k)) {
                cnt += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}
