package leetcode.template.BackTracking;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/20 18:08
 */

    // 无重复元素的数组 candidates 和一个目标数 target
    // 找出 candidates 中所有可以使数字和为 target 的组合。
    // candidates 中的数字可以无限制重复被选取。
    //  [2,3,6,7], target = 7
    // [
    //  [7],
    //  [2,2,3]
    //]


    // 对于每一个数，有选或者不选两种情况
public class Q39_CombinationSum {
    // 1. 回溯
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum1(int[] nums, int target) {
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
            list.add(nums[i]);
            dfs(nums, i, target - nums[i], list);
            list.remove(list.size() - 1);
        }
    }
    // 2. 完全背包

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(100);

        System.out.println(list);
    }
}
