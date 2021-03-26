package leetcode.template.DP;

import leetcode.template.Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/20 1:11
 */


//     3
//    / \
//  100  5
//  / \   \
// 1   3  100

    // -> 200
public class Q337_打家劫舍3_树上DP {
    // 做了一次后序遍历
    // 选当前节点
    Map<TreeNode, Integer> f = new HashMap<>();
    // 不选当前节点
    Map<TreeNode, Integer> g = new HashMap<>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.get(root), g.get(root));
    }
    public void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        f.put(root, root.val + g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0));
        g.put(root, Math.max(g.getOrDefault(root.left, 0), f.getOrDefault(root.left, 0)) +
                Math.max(g.getOrDefault(root.right, 0), f.getOrDefault(root.right, 0)) );
    }


    public int rob1(TreeNode root) {
        int[] ans = dfs1(root);
        return Math.max(ans[0], ans[1]);
    }
    public int[] dfs1(TreeNode root) {
        if(root == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs1(root.left);
        int[] r = dfs1(root.right);
        int f = root.val + l[1] + r[1];
        int g = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{f, g};
    }
}
