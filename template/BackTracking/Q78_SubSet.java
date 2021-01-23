package leetcode.template.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/29 18:03
 */
public class Q78_SubSet {
    // bit子集
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        // 111 [1,2,3]
        // 110 [1,2]
        // 101 [1,3]
        // 100 [1]
        // 011 [2,3]
        // 010 [2]
        // 001 [3]
        // 000 []
        List<List<Integer>> ans = new ArrayList<>();
        // 1 10 11 100 101 110 111
        for(int mask = 1; mask < (1 << n); mask++) {
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                if(((mask >> i) & 1) == 1) {
                    list.add(nums[i]);
                }
            }
            ans.add(list);
        }
        ans.add(new ArrayList<Integer>());
        return ans;
    }
    // 2.增量构造
    public List<List<Integer>> subsets2(int[] nums) {
        // [[]]
        // [[],[1]]
        // [[],[1],[2],[1,2]]
        // [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
    //
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
}
