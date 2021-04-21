package leetcode.template.Tree;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/5 15:39
 */
public class Q124_二叉树最大路径和 {
    int ans;
    int MIN;
    public int maxPathSum(TreeNode root) {
        MIN = -0x3f3f3f3f;
        ans = MIN;
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root) {
        if(root.left == null && root.right == null) {
            ans = Math.max(ans, root.val);
            return root.val;
        }
        int l = root.left == null ? MIN : dfs(root.left);
        int r = root.right == null ? MIN : dfs(root.right);
        int ret = Math.max(root.val, root.val + Math.max(l, r));
        ans = Math.max(ans, Math.max(ret, root.val + l + r));
        return ret;
    }
}
