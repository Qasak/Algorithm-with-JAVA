package leetcode.template.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/1 16:41
 */
public class Q199_right {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int m = q.size();
            TreeNode n = null;
            for(int i = 0; i < m; i++) {
                n = q.poll();
                if(n.left != null) {
                    q.offer(n.left);
                }
                if(n.right != null) {
                    q.offer(n.right);
                }
            }
            ans.add(n.val);
        }
        return ans;
    }
}
