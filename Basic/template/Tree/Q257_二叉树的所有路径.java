package leetcode.template.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/5 11:24
 */
public class Q257_二叉树的所有路径 {
    List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root, new StringBuilder());
        return ans;
    }
    public void dfs(TreeNode root, StringBuilder t) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            int m = t.length();
            t.append(String.valueOf(root.val));
            ans.add(t.toString());
            t.setLength(m);
            return;
        }
        int m = t.length();
        t.append(String.valueOf(root.val) + "->");
        dfs(root.left, t);
        dfs(root.right, t);
        t.setLength(m);
    }

}
