package leetcode.template.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/5 17:57
 */
public class Q325_MaxSubArrayLen {
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        int[] sum = new int[n + 1];
        for(int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        // 0 [1,0,5,3,6]
        // 0  1 2 3 4 5
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for(int i = 1; i <= n; i++) {
            if(map.containsKey(sum[i] - k)) {
                ans = Math.max(ans, i - map.get(sum[i] - k) );
            }
            // 这样存的i是最远的
            map.putIfAbsent(sum[i], i);
        }
        return ans;
    }
    public int maxSubArrayLen1(int[] nums, int k) {
        int max = 0;
        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                max = Math.max(max, i - map.get(sum - k) );
            }
            map.putIfAbsent(sum, i);

        }
        return max;
    }
}
