package leetcode.contest.NiceProblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/2 10:10
 */
public class Q523_连续的子数组和 {
    // 前缀和 + 同余定理

    // 若n,m对k同余，则(n-m)能被k整除
    // n = x*k + rem
    // m = y*k + rem
    // n - m = k*(x - y)
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        for(int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }

        // 余数 : 下标
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < n; i++) {
            int rem = pre[i + 1] % k;
            if(map.containsKey(rem) && i - map.get(rem) >= 2) {
                return true;
            }
            if(!map.containsKey(rem)) {
                map.put(rem, i);
            }
        }
        return false;
    }
    // HashSet
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            int n = nums.length;
            int[] pre = new int[n + 1];
            for(int i = 0; i < n; i++) {
                pre[i + 1] = pre[i] + nums[i];
            }
            Set<Integer> set = new HashSet<>();
            for(int i = 1; i < n; i++) {
                set.add(pre[i - 2 + 1] % k);
                if(set.contains(pre[i + 1] % k)) {
                    return true;
                }
            }
            return false;
        }
    }
}
