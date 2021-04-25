package leetcode.SpringRecruit.Tree;

import leetcode.template.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/13 9:21
 */
public class Q783_二叉搜索树节点最小距离 {
    private int min = Integer.MAX_VALUE;
    private List<Integer> list;
    public int minDiffInBST(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);
        for(int i = 0; i < list.size() - 1; i++) {
            min = Math.min(min, list.get(i + 1) - list.get(i));
        }
        return min;
    }
    public void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
