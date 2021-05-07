package leetcode.HighFreq;

import leetcode.template.Tree.TreeNode;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/25 19:11
 */
public class Q124_二叉树最大路径和 {
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }

    // 返回包含根节点的单链最大值
    public int dfs(TreeNode root) {
        if(root == null) {
            return -1001;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        int cur = root.val;
        // 返回值过根
        int[] tmp1 = new int[]{cur, cur + l, cur + r};
        int ret = Arrays.stream(tmp1).max().getAsInt();
        // 最大值可能过根 / 不过根 / 双链
        int[] tmp2 = new int[]{l, r, ret, cur + l + r};
        max = Math.max(max, Arrays.stream(tmp2).max().getAsInt());
        return ret;
    }
}
