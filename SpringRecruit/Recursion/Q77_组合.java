package leetcode.SpringRecruit.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/26 18:08
 */
public class Q77_组合 {
    List<List<Integer>> ans = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> combine(int n, int k) {
        nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        dfs(0, nums, 0, k, new ArrayList<>());
        return ans;
    }
    public void dfs(int idx, int[] nums, int cnt, int k, List<Integer> path) {
        if(cnt == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        int n = nums.length;
        for(int i = idx; i < n; i++) {
            path.add(nums[i]);
            dfs(i + 1, nums, cnt + 1, k, path);
            path.remove(path.size() - 1);
        }
    }

}
