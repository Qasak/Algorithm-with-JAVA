package leetcode.contest.NiceProblem;

import leetcode.template.Tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/7 23:45
 */
public class Q114_二叉树栈开为链表 {
    public void flatten(TreeNode root) {
        Deque<TreeNode> stk = new LinkedList<>();
        while(root != null || !stk.isEmpty()) {
            if(root.right != null) {
                stk.push(root.right);
            }
            if(root.left != null) {
                TreeNode t = root.left;
                root.left = null;
                root.right = t;
                root = t;
            } else {
                if(!stk.isEmpty()) {
                    root.right = stk.pop();
                    root.left = null;
                }
                root = root.right;
            }
        }
    }
}
