package leetcode.SpringRecruit.Recursion;

import leetcode.template.Tree.TreeNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/21 14:02
 */
public class Q124_二叉树中的最大路径和 {
    int ans = -0x3f3f3f3f;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        // 不穿过
        int ret = Math.max(Math.max(l, r) + root.val, root.val);
        // 穿过
        ans = Math.max(ans, Math.max(ret, l + r + root.val));
        return ret;
    }
}
