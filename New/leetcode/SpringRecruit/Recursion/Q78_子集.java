package leetcode.SpringRecruit.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/26 15:30
 */
public class Q78_子集 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }
    public void dfs(int[] nums, int idx, List<Integer> path) {
        int n = nums.length;
        if(idx == n) {
            ans.add(new ArrayList<>(path));
            return;
        }
        dfs(nums, idx + 1, path);
        path.add(nums[idx]);
        dfs(nums, idx + 1, path);
        path.remove(path.size() - 1);
    }

    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        public List<List<Integer>> subsets(int[] nums) {
            ans.add(new ArrayList<>());
            dfs(nums, 0, new ArrayList<>());
            return ans;
        }
        public void dfs(int[] nums, int idx, List<Integer> path) {
            int n = nums.length;
            if(idx == n) {
                return;
            }
            for(int i = idx; i < n; i++) {
                path.add(nums[i]);
                ans.add(new ArrayList<>(path));
                dfs(nums, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
