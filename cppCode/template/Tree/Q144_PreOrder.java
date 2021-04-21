package leetcode.template.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/25 11:59
 */
public class Q144_PreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while(root != null || !stk.isEmpty()) {
            while(root != null) {
                ans.add(root.val);
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            root = root.right;
        }
        return ans;
    }
}
