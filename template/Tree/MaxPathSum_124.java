package leetcode.template.Tree;

import leetcode.template.MonotonousStack.MaxNumber_321;
import leetcode.template.Tree.TreeNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/3 14:56
 * 给定一个非空二叉树，返回其最大路径和。
 * 输入：[1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出：6
 *
 */
public class MaxPathSum_124 {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        depth(root);
        return ans;
    }
    /**
     对于任意一个节点, 如果最大和路径包含该节点, 那么只可能是两种情况:
     1. 其左右子树中所构成的和路径值较大的那个加上该节点的值后向父节点回溯构成最大路径
     2. 左右子树都在最大路径中, 加上该节点的值构成了最终的最大路径
     **/
    private int depth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // 如果子树路径和为负则应当置0表示最大路径不包含子树
        int l = Math.max(0, depth(root.left));
        int r = Math.max(0, depth(root.right));
        // 判断在该节点包含左右子树的路径和是否大于当前最大路径和
        // 2. 左右子树都在最大路径中, 加上该节点的值构成了最终的最大路径
        ans = Math.max(ans, root.val + l + r);
        // 1. 其左右子树中所构成的和路径值较大的那个加上该节点的值后向父节点回溯构成最大路径
        return root.val + Math.max(l, r);
    }
}
