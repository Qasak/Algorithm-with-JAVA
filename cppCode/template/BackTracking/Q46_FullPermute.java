package leetcode.template.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/20 17:54
 */
public class Q46_FullPermute {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        dfs(nums, 0);
        return ans;
    }
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    private void dfs(int[] nums, int idx) {
        int n = nums.length;
        if(idx == n) {
            List<Integer> list = new ArrayList<>();
            for(int i: nums) {
                list.add(i);
            }
            ans.add(list);
            return;
        }
        for(int i = idx; i < n; i++) {
            swap(nums, i, idx);
            dfs(nums, idx + 1);
            swap(nums, i, idx);
        }
    }

    boolean[] vis;
    public List<List<Integer>> permute1(int[] nums) {
        ans = new ArrayList<>();
        vis = new boolean[nums.length];
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }
    private void dfs(int[] nums, int idx, List<Integer> list) {
        int n = nums.length;
        if(idx == n) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < n; i++) {
            if(vis[i]) {
                continue;
            }
            vis[i] = true;
            list.add(nums[i]);
            dfs(nums, idx + 1, list);
            list.remove(list.size() - 1);
            vis[i] = false;
        }
    }
}
