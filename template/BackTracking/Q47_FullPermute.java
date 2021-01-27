package leetcode.template.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/20 15:29
 */

// 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
    // 时间复杂度：O(n×n!)，其中 n为序列的长度
    // 空间复杂度 O(n), 递归栈深度n
public class Q47_FullPermute {
    List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        dfs(nums, 0);
        return ans;
    }

    // 当前排列为 nums，下一个待填入的位置是第 idx 个位置
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
        // idx < n 考虑第idx个位置填哪个数
        for(int i = idx; i < n; i++) {
            Arrays.sort(nums, idx, n);
            if(i + 1 < n && nums[i] == nums[i + 1]) {
                continue;
            }
            swap(nums, i, idx);
            dfs(nums, idx + 1);
            swap(nums, i, idx);
        }

    }
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    // 2. 用vis数组记录已访问的位置
    // 剪枝
    boolean vis[];
    public List<List<Integer>> permuteUnique1(int[] nums) {
        Arrays.sort(nums);
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
        // 第idx 个位置填哪个数
        for(int i = 0; i < n; i++) {
            if(vis[i] || (i > 0 && nums[i - 1] == nums[i] && !vis[i - 1])) {
                continue;
            }
            vis[i] = true;
            list.add(nums[i]);
            dfs(nums, idx + 1, list);
            list.remove(list.size() - 1);
            vis[i] = false;
        }
    }
    public static void main(String[] args) {
        char[] a = new char[]{0, 'b'};
        System.out.println(a.length);
        String s = new String(a);
        System.out.println(a);
        System.out.println(s.length());
    }
}
