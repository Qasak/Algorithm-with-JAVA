package leetcode.template.BackTracking;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/29 18:14
 */
public class Q90_SubSet2 {
    // 1. 状态压缩
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // [1,2,2] 11 == 101
        // 1 10 11 100 101 110 111
        for(int mask = 1; mask < (1 << n); mask++) {
            boolean flag = false;
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                if(((mask >> i) & 1) == 1) {
                    if(i > 0 && nums[i] == nums[i - 1] && ((mask >> (i - 1)) & 1) == 0 ) {
                        flag = true;
                        break;
                    } else {
                        list.add(nums[i]);
                    }
                }
            }
            if(!flag) {
                ans.add(list);
            }
        }
        ans.add(new ArrayList<Integer>());
        return ans;
    }
    // 2. 回溯 : 排序 + Set去重
    Set<List<Integer>> set;
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        Arrays.sort(nums);
        // [[],[1],[2],[1,2],[2],[1,2],[2,2],[1,2,2]]
        set = new HashSet<>();
        dfs(nums, 0, new ArrayList<>());
        return new ArrayList<>(set);
    }
    private void dfs(int[] nums, int idx, List<Integer> list) {
        int n = nums.length;
        if(idx == n) {
            set.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[idx]);
        dfs(nums, idx + 1, list);
        list.remove(list.size() - 1);
        dfs(nums, idx + 1, list);
    }
    // 回溯 + 剪枝
    List<List<Integer>> ans;
    boolean vis[];
    public List<List<Integer>> subsetsWithDup4(int[] nums) {
        Arrays.sort(nums);
        // [[],[1],[2],[1,2],[2],[1,2],[2,2],[1,2,2]]
        ans = new ArrayList<>();
        vis = new boolean[nums.length];
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }
    private void dfs2(int[] nums, int idx, List<Integer> list) {
        int n = nums.length;
        if(idx == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        dfs2(nums, idx + 1, list);
        if(vis[idx] || (idx > 0 && nums[idx - 1] == nums[idx] && !vis[idx - 1]) ) {
            return;
        }
        vis[idx] = true;
        list.add(nums[idx]);
        dfs2(nums, idx + 1, list);
        list.remove(list.size() - 1);
        vis[idx] = false;
    }


    // 3. 回溯 + 同层去重
    public List<List<Integer>> subsetsWithDup3(int[] nums) {
        Arrays.sort(nums);
        // [[],[1],[2],[1,2],[2],[1,2],[2,2],[1,2,2]]
        ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        dfs1(nums, 0, new ArrayList<>());
        return ans;
    }
    private void dfs1(int[] nums, int idx, List<Integer> list) {
        int n = nums.length;
        if(idx == n) {
            return;
        }
        for(int i = idx; i < n; i++) {
            if(i > idx && nums[i - 1] == nums[i]) {
                continue;
            }
            list.add(nums[i]);
            ans.add(new ArrayList<>(list));
            dfs1(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
    public static void main(String[] args) {
        String a = String.valueOf(2);
        System.out.println(a);
    }
}
