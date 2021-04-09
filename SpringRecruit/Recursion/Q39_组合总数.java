package leetcode.SpringRecruit.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/26 22:18
 */
public class Q39_组合总数 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, new ArrayList<>(), 0);
        return ans;
    }
    public void dfs(int[] nums, int target, List<Integer> path, int idx) {
        int sum = 0;
        for(int c : path) {
            sum += c;
        }
        if(sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        int n = nums.length;
        if(sum > target || idx == n) {
            return;
        }
        path.add(nums[idx]);
        dfs(nums, target, path, idx);
        path.remove(path.size() - 1);
        dfs(nums, target, path, idx + 1);
    }

    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            dfs(candidates, target, new ArrayList<>(), 0);
            return ans;
        }
        public void dfs(int[] nums, int target, List<Integer> path, int idx) {
            if(target < 0) {
                return;
            }
            if(target == 0) {
                ans.add(new ArrayList<>(path));
                return;
            }
            int n = nums.length;
            for(int i = idx; i < n; i++) {
                path.add(nums[i]);
                dfs(nums, target - nums[i], path, i);
                path.remove(path.size() - 1);
            }
        }
    }

    class Solution1 {
        List<List<Integer>> ans = new ArrayList<>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            dfs(candidates, target, new ArrayList<>(), 0);
            return ans;
        }
        public void dfs(int[] nums, int target, List<Integer> path, int idx) {
            if(target == 0) {
                ans.add(new ArrayList<>(path));
                return;
            }
            int n = nums.length;
            if(idx == n) {
                return;
            }
            if(target - nums[idx] >= 0) {
                path.add(nums[idx]);
                dfs(nums, target - nums[idx], path, idx);
                path.remove(path.size() - 1);
            }
            dfs(nums, target, path, idx + 1);
        }
    }
}
