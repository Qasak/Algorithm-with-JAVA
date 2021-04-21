package leetcode.template.Tree;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/1 16:40
 */
public class Q103_LevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = true;
        while(!q.isEmpty()) {
            int m = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < m; i++) {
                TreeNode n = q.poll();
                list.add(n.val);
                if(n.left != null) {
                    q.offer(n.left);
                }
                if(n.right != null) {
                    q.offer(n.right);
                }
            }
            if(!flag) {
                Collections.reverse(list);
            }
            flag = !flag;
            ans.add(list);
        }
        return ans;
    }
}
