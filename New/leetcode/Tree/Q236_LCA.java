package leetcode.template.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/1 16:48
 */
public class Q236_LCA {
    // 所有 Node.val 互不相同

    // root 定义的父节点为null

    Map<Integer, TreeNode> map;
    Map<Integer, Integer> depth;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        map = new HashMap<>();
        depth = new HashMap<>();
        getDepth(root, null, 0);
        return getLCA(p, q);
    }

    public void getDepth(TreeNode node, TreeNode parant, int d) {
        if(node == null) {
            return;
        }
        map.put(node.val, parant);
        depth.put(node.val, d);
        getDepth(node.left, node, d + 1);
        getDepth(node.right, node, d + 1);
    }

    public TreeNode getLCA(TreeNode p, TreeNode q) {
        while(depth.get(p.val) < depth.get(q.val)) {
            q = map.get(q.val);
        }
        while(depth.get(q.val) < depth.get(p.val)) {
            p = map.get(p.val);
        }
        while(p != q) {
            p = map.get(p.val);
            q = map.get(q.val);
        }
        return p;
    }

    // 直接递归
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode l = lowestCommonAncestor1(root.left, p, q);
        TreeNode r = lowestCommonAncestor1(root.right, p, q);
        if(l != null && r != null) {
            return root;
        } else if(l != null) {
            return l;
        } else {
            return r;
        }
    }

}
