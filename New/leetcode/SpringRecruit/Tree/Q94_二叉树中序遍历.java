package leetcode.SpringRecruit.Tree;

import leetcode.template.Tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/13 9:30
 */
public class Q94_二叉树中序遍历 {
    private List<Integer> list;
    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while(root != null || !stk.isEmpty()) {
            while(root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}
