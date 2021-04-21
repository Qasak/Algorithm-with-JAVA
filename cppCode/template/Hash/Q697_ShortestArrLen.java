package leetcode.template.Hash;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/13 17:28
 */
public class Q697_ShortestArrLen {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        int d = 0;
        int ans = 0x3f3f3f3f;
        for(int i : map.keySet()) {
            d = Math.max(d, map.get(i).size());
        }
        for(int i : map.keySet()) {
            if(d == map.get(i).size()) {
                List<Integer> list = map.get(i);
                int len = list.get(list.size() - 1) - list.get(0) + 1;
                ans = Math.min(ans, len);
            }
        }
        return ans;
    }
    // 官方
    public int findShortestSubArray1(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>(),
                right = new HashMap<>(), count = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            left.putIfAbsent(x, i);
            right.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int ans = nums.length;
        int degree = Collections.max(count.values());
        for (int x: count.keySet()) {
            if (count.get(x) == degree) {
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
            }
        }
        return ans;
    }


}
