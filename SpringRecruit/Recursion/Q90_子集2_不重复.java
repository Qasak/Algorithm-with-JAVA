package leetcode.SpringRecruit.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/26 17:24
 */
public class Q90_子集2_不重复 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        ans.add(new ArrayList<>());
        return ans;
    }
    public void dfs(int[] nums, int idx, List<Integer> path) {
        int n = nums.length;
        if(idx == n) {
            return;
        }
        for(int i = idx; i < n; i++) {
            // 就加这一句话
            if(i > idx && nums[i] == nums[i - 1]) {
                continue;
            }


            path.add(nums[i]);
            ans.add(new ArrayList<>(path));
            dfs(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
