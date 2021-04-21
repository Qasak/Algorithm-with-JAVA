package leetcode.template.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/5 11:12
 */
public class Q113_路径总和2 {
    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        dfs(root, targetSum, new ArrayList<>());
        return ans;

    }

    public void dfs(TreeNode root, int cur, List<Integer> path) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            if(cur - root.val == 0) {
                path.add(root.val);
                ans.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(root.val);
        dfs(root.left, cur - root.val, path);
        dfs(root.right, cur - root.val, path);
        path.remove(path.size() - 1);
    }
}
