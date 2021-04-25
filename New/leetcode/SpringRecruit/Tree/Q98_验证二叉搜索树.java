package leetcode.SpringRecruit.Tree;

import leetcode.template.Tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/13 9:36
 */
public class Q98_验证二叉搜索树 {
    // 1. dfs 记录pre
    class Solution {
        private int pre;
        private boolean first;
        public boolean isValidBST(TreeNode root) {
            if(root == null) {
                return true;
            }
            first = true;
            pre = Integer.MIN_VALUE;
            return dfs(root);

        }
        private boolean dfs(TreeNode root) {
            if(root == null) {
                return true;
            }
            boolean l = dfs(root.left);

            if(first) {
                pre = root.val;
                first = false;
            } else {
                if(root.val <= pre) {
                    return false;
                }
            }

            pre = root.val;
            boolean r = dfs(root.right);
            return l && r;
        }
    }
    // 2. stk非递归中序
    class Solution1 {
        public boolean isValidBST(TreeNode root) {
            Deque<TreeNode> stk = new LinkedList<>();
            // Double.MIN_VALUE: A constant holding the smallest positive nonzero value of type
            // Double.MIN_VALUE: 最小的非零[正数]值
            double pre = -Double.MAX_VALUE;
            // System.out.println(pre);
            while(root != null || !stk.isEmpty()) {
                while(root != null) {
                    stk.push(root);
                    root = root.left;
                }
                root = stk.pop();
                if(root.val <= pre) {
                    return false;
                }
                pre = root.val;
                root = root.right;
            }
            return true;
        }
    }
    // 3. 递归函数传入左右节点参数
    class Solution2 {
        public boolean isValidBST(TreeNode root) {
            return inOrder(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }
        public boolean inOrder(TreeNode root, long l, long r) {
            if(root == null) {
                return true;
            }
            if(root.val <= l || root.val >= r) {
                return false;
            }
            return inOrder(root.left, l, root.val) && inOrder(root.right, root.val, r);
        }
    }
}
