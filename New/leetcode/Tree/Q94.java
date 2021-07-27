package leetcode.template.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/24 10:05
 */
public class Q94 {
    List<Integer> ans;
    public List<Integer> inorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        inoder(root);
        return ans;
    }
    public void inoder(TreeNode root) {
        if(root == null) {
            return;
        }
        inoder(root.left);
        ans.add(root.val);
        inoder(root.right);
    }

    // 非递归
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while(root != null || !stk.isEmpty()) {
            while(root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        Deque<TreeNode> stk = new LinkedList<>();
        TreeNode t = root;
        while(t != null) {
            stk.push(t);
            t = t.left;
            while(t == null && !stk.isEmpty()) {
                t = stk.pop();
                ans.add(t.val);
                t = t.right;
            }

        }
        return ans;
    }
}
