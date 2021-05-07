package leetcode.HighFreq;

import leetcode.template.Tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/26 16:49
 */
public class Q102_二叉树层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int n = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}
