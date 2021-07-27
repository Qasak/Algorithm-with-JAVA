package leetcode.template.Tree.DFS;

import leetcode.TreeNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/27 11:40
 */
public class Q671_二叉树中第二小的节点 {
    int ans = -1;
    public int findSecondMinimumValue(TreeNode root) {
        dfs(root, root.val);
        return ans;
    }
    private void dfs(TreeNode root, int pre) {
        if(root == null) {
            return;
        }
        int cur = root.val;
        if(cur != pre) {
            if(ans == -1) {
                ans = cur;
            } else {
                ans = Math.min(ans, cur);
            }
            return;
        }
        dfs(root.left, cur);
        dfs(root.right, cur);
    }
}
