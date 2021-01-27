package leetcode.template.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/29 18:03
 */
// 2 ^ n 个 子集
public class Q78_SubSet {
    // 1.bit子集
    // [[]]
    // [[],[1]]
    // [[],[1],[2],[1,2]]
    // [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());
        for(int mask = 1; mask < (1 << n); mask++) {
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                if(((mask >> i) & 1) == 1) {
                    list.add(nums[i]);
                }
            }
            ans.add(list);
        }
        return ans;
    }
    // 2.增量构造
    // [[]]
    // [[],[1]]
    // [[],[1],[2],[1,2]]
    // [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    public List<List<Integer>> subsets2(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for(int i = 0; i < n; i++) {
            int m = ans.size();
            for(int j = 0; j < m; j++) {
                List<Integer> tmp = new ArrayList<>(ans.get(j));
                tmp.add(nums[i]);
                ans.add(tmp);
            }
        }
        return ans;
    }
    // 回溯
    // 1.
    // [1,2,3]
    // [1,2,3] [1,2] [1,3] [2,3] [2] [3] []
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets1(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        // 选择当前位置
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        // 不选择当前位置
        dfs(cur + 1, nums);
    }
    // 2.
    //
    // [] [1] [1,2] [1,2,3] [1,3] [2] [2,3] [3]
    public List<List<Integer>> subsets3(int[] nums) {
        ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }
    private void dfs(int[] nums, int idx, List<Integer> list) {
        int n = nums.length;
        if(idx == n) {
            return;
        }
        for(int i = idx; i < n; i++) {
            list.add(nums[i]);
            ans.add(new ArrayList<>(list));
            dfs(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
