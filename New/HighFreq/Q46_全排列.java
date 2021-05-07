package leetcode.HighFreq;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/25 23:52
 */
public class Q46_全排列 {
    List<List<Integer>> ans;
    boolean[] vis;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        vis = new boolean[nums.length];
        dfs(new ArrayList<>(), nums);
        return ans;
    }
    public void dfs(List<Integer> path, int[] nums) {
        int n = nums.length;
        if(path.size() == n) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < n; i++) {
            if(vis[i]) {
                continue;
            }
            vis[i] = true;
            path.add(nums[i]);
            dfs(path, nums);
            path.remove(path.size() - 1);
            vis[i] = false;
        }
    }
}
