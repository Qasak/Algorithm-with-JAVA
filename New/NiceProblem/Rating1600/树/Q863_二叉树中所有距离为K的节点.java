package leetcode.contest.Rating1600.树;

import leetcode.TreeNode;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/28 9:08
 */
public class Q863_二叉树中所有距离为K的节点 {
    List<Integer> ans = new ArrayList<>();
    Map<Integer, List<TreeNode>> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        build(root);
        set.add(target.val);
        bfs(target, K);
        return ans;
    }
    void build(TreeNode root) {
        if(root == null) {
            return;
        }
        int u = root.val;
        if(root.left != null) {
            int v = root.left.val;
            map.putIfAbsent(u, new ArrayList<>());
            map.putIfAbsent(v, new ArrayList<>());

            map.get(u).add(root.left);
            map.get(v).add(root);
            build(root.left);
        }
        if(root.right != null) {
            int v = root.right.val;
            map.putIfAbsent(u, new ArrayList<>());
            map.putIfAbsent(v, new ArrayList<>());

            map.get(u).add(root.right);
            map.get(v).add(root);
            build(root.right);
        }
    }
    void bfs(TreeNode root, int dist) {
        if(root == null) {
            return;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty() && dist > 0) {
            int size = q.size();
            while(size-- > 0) {
                TreeNode u = q.poll();
                List<TreeNode> list = map.get(u.val);
                if(list == null) {
                    continue;
                }
                for(TreeNode v : list) {
                    if(!set.contains(v.val)) {
                        set.add(v.val);
                        q.offer(v);
                    }
                }
            }
            dist--;
        }

        while(!q.isEmpty()) {
            int val = q.poll().val;
            ans.add(val);
        }
    }
}
