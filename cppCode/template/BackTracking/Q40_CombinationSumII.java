package leetcode.template.BackTracking;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/21 22:19
 */
public class Q40_CombinationSumII {
    // set去重：很慢

    // 1.排序后剪枝
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new ArrayList<Integer>(), 0, 0, target);
        return ans;
    }
    // 10,1,2,7,6,1,5
    // 1,1,2,5,6,7,10
    private void dfs(int[] nums, List<Integer> list, int idx, int cur, int target) {

        if(idx == nums.length || cur >= target) {
            if(cur == target) {
                ans.add(new ArrayList<Integer>(list));
            }
            return;
        }
        for(int i = idx; i < nums.length; i++) {
            // 同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过
            if(i > idx) {
                if(nums[i] == nums[i - 1]) {
                    continue;
                }
            }
            list.add(nums[i]);
            dfs(nums, list, i + 1, cur + nums[i], target);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2_1(int[] nums, int target) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        dfs(nums, 0, target, new ArrayList<>());
        return ans;
    }
    private void dfs(int[] nums, int idx, int target, List<Integer> list) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = idx; i < nums.length; i++) {
            if(i > idx && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            dfs(nums, i + 1, target - nums[i], list);
            list.remove(list.size() - 1);
        }
    }
}
