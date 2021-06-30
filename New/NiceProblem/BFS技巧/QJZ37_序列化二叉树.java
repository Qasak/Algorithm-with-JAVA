package leetcode.contest.NiceProblem.BFS技巧;

import leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/30 9:11
 */
public class QJZ37_序列化二叉树 {
    // 两次层序遍历
    public String serialize(TreeNode root) {
        if(null == root) {
            return "";
        }
        StringBuilder ret = new StringBuilder();
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i = 0; i < n; i++) {
                TreeNode cur = q.poll();
                if(null == cur) {
                    ret.append("x").append(",");
                    continue;
                }
                ret.append(cur.val).append(",");
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        return ret.toString();
    }
    // BFS每次加2
    public TreeNode deserialize(String data) {
        if(data.length() == 0) {
            return null;
        }
        String[] nodes = data.split(",");
        int n = nodes.length;
        int i = 1;
        Deque<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(!"x".equals(nodes[i])) {
                node.left = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(node.left);
            }
            i++;
            if(!"x".equals(nodes[i])) {
                node.right = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(node.right);
            }
            i++;
        }
        return root;
    }

    // 先序

}
