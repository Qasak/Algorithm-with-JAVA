package leetcode.SpringRecruit.StackAndQueue;

import leetcode.template.Tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/28 9:41
 */
public class Q94_二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        Deque<TreeNode> stk = new LinkedList<>();
        stk.push(root);
        while(root != null || !stk.isEmpty()) {
            while(root != null) {
                root = root.left;
                if(root != null) {
                    stk.push(root);
                }
            }
            root = stk.pop();
            ans.add(root.val);
            root = root.right;
            if(root != null) {
                stk.push(root);
            }
        }
        return ans;
    }
    // 遍历2 ： 不用先push root
}
