package leetcode.template.Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/1 12:36
 */
public class Q442_FindDuplicate {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            if(e.getValue() == 2) {
                ans.add(e.getKey());
            }
        }
        return ans;
    }
    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int[] cnt = new int[nums.length + 1];
        for(int i: nums) {
            cnt[i]++;
        }
        for(int i = 0 ; i < nums.length + 1; i++) {
            if(cnt[i] == 2) {
                ans.add(i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
    }
}
