package leetcode.template.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/19 15:49
 */
public class Q1382 {
    List<Integer> list;
    public TreeNode balanceBST(TreeNode root) {
        list = new ArrayList<>();
        inOrder(root);
        return build(list, 0, list.size() - 1);
    }
    private TreeNode build(List<Integer> list, int l, int r) {
        if(l > r) {
            return null;
        }
        int m = (l + r) / 2;
        TreeNode root = new TreeNode(list.get(m));
        root.left = build(list, l, m - 1);
        root.right = build(list, m + 1, r);
        return root;
    }
    private void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}
