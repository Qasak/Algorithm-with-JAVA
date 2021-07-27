package leetcode.template.Tree.BFS;

import leetcode.template.Tree.TreeNode;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/29 12:43
 */
public class Q1660_CorrectTree {
    public TreeNode correctBinaryTree(TreeNode root) {
        // [同一层]且在其[右侧]的一个其他节点。
        // [ left/ right, parent]
        // q：当前节点和这个节点的父节点
        Deque<TreeNode[]> q = new LinkedList<>();
        q.offer(new TreeNode[]{root, null});
        while(!q.isEmpty()) {
            int n = q.size();
            HashMap<TreeNode, TreeNode> map = new HashMap<>();
            for(int i = 0; i < n; i++) {
                TreeNode[] t = q.poll();
                TreeNode cur = t[0];
                TreeNode parent = t[1];

                map.put(cur, parent);
                if(cur.left != null) {
                    q.offer(new TreeNode[]{cur.left, cur});
                }
                if(cur.right != null) {
                    q.offer(new TreeNode[]{cur.right, cur});
                }
            }
            for(TreeNode t : map.keySet()) {
                if(map.containsKey(t.right)) {
                    TreeNode parent = map.get(t);
                    if(parent.left == t) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                    return root;
                }
            }
        }
        return root;
    }
    // 更好的BFS
    public TreeNode correctBinaryTree1(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.right != null && map.containsKey(node.right)) {
                TreeNode parent = map.get(node);
                if(parent.left == node) {   //removes the culpit
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                return root;
            }
            if(node.left != null) {
                map.put(node.left, node);
                q.offer(node.left);
            }
            if(node.right != null) {
                map.put(node.right, node);
                q.offer(node.right);
            }
        }
        return root;
    }
}
