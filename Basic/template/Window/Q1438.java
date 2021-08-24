package leetcode.template.Window;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/21 9:46
 */
public class Q1438 {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0, ans = 0;
        for(int r = 0; r < n; r++) {
            set.add(nums[r]);
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while(set.last() - set.first() > limit) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if(map.get(nums[l]) == 0) {
                    set.remove(nums[l]);
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
    // TreeMap
    public int longestSubarray1(int[] nums, int limit) {
        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int l = 0, ans = 0;
        for(int r = 0; r < n; r++) {

            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while(l < r && map.lastKey() - map.firstKey() > limit) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if(map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
