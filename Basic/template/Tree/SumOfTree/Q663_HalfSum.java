package leetcode.template.Tree.SumOfTree;

import leetcode.TreeNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/29 15:35
 */
public class Q663_HalfSum {
    int sum = 0;
    public boolean checkEqualTree(TreeNode root) {
        if(root == null) {
            return false;
        }
        this.sum = treeSum(root);
        if((sum & 1) == 1) {
            return false;
        }
        return checkEqual(root);

    }
    public boolean checkEqual(TreeNode root) {
        if(root == null) {
            return false;
        }
        int lsum = treeSum(root.left);
        int rsum = treeSum(root.right);
        if((root.left != null && lsum == sum / 2) || (root.right != null && rsum == sum / 2)) {
            return true;
        } else {
            return checkEqual(root.left) || checkEqual(root.right);
        }
    }
    // 子树的和
    private int treeSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int lsum = treeSum(root.left);
        int rsum = treeSum(root.right);
        return lsum + rsum + root.val;
    }
}
