package leetcode.template.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/17 11:24
 */
public class Q5243_Prod {
    public int tupleSameProduct(int[] nums) {
        // Arrays.sort(nums);
        //ans x 8
        //
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                map.put(nums[i] * nums[j], map.getOrDefault(nums[i] * nums[j], 0) + 1);
            }
        }
        int ans = 0;
        for(int i: map.keySet()) {
            if(map.get(i) > 1) {
                ans += map.get(i);
//                map.remove(i);
            }
        }
        return ans * 8;
    }
}
