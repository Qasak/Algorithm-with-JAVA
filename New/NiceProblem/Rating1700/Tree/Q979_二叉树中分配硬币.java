package leetcode.contest.Rating1700.Tree;

import leetcode.TreeNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/28 17:43
 */
public class Q979_二叉树中分配硬币 {
    int opt = 0;
    public int distributeCoins(TreeNode root) {
        // 根节点的负债一定是平衡的
        System.out.println(dfs(root));
        return opt;
    }
    // 返回子树整体负债数量
    // 负债会向上传递
    int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int cur = root.val - 1;
        int l = dfs(root.left);
        int r = dfs(root.right);
        // 两边负债量绝对值之和 == 当前节点操作次数
        opt += Math.abs(l) + Math.abs(r);
        return l + r + root.val - 1;
    }
}
