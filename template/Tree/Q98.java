package leetcode.template.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/24 10:25
 */
public class Q98 {
    // 1.保存所有节点值
    List<Integer> list;
    public boolean isValidBST(TreeNode root) {
        list = new ArrayList<>();
        in(root);
        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
    public void in(TreeNode root) {
        if(root == null) {
            return;
        }
        in(root.left);
        list.add(root.val);
        in(root.right);
    }
    // 直接递归
    public boolean isValidBST1(TreeNode root) {
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
    // 非递归中序
    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stk = new LinkedList<>();
        TreeNode t = root;
        long p = Long.MIN_VALUE;
        while(t != null || !stk.isEmpty()) {
            while(t != null) {
                stk.push(t);
                t = t.left;
            }
            t = stk.pop();
            if(t.val <= p) {
                return false;
            }
            p = t.val;
            t = t.right;
        }
        return true;
    }
}
