package leetcode.SpringRecruit.Tree;

import leetcode.template.Tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/25 13:13
 */
public class Q897_递增顺序搜索树 {
    // 中序非递归
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while(!stk.isEmpty() || root != null) {
            if(root != null) {
                stk.push(root);
                root = root.left;
            } else {
                root = stk.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        TreeNode d = new TreeNode(-1);
        TreeNode p = d;
        for(int i : list) {
            p.right = new TreeNode(i);
            p.left = null;
            p = p.right;
        }
        return d.right;
    }
}
