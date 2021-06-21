package leetcode.contest.NiceProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/21 17:19
 */
public class Q77_组合 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        // 1,2,3,4,5
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        dfs(nums, k, 0, new ArrayList<>());
        return ans;
    }
    public void dfs(int[] nums, int k, int idx, List<Integer> cur) {
        if(cur.size() == k) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i = idx; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(nums, k, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
