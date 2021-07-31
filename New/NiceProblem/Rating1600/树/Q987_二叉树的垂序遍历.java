package leetcode.contest.Rating1600.树;

import leetcode.TreeNode;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/31 9:32
 */
public class Q987_二叉树的垂序遍历 {
    class Node {
        TreeNode node;
        int col;
        public Node(TreeNode n, int c) {
            node = n;
            col = c;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        // col: Nodes
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Deque<Node> q = new LinkedList<>();
        q.offer(new Node(root, 0));
        while(!q.isEmpty()) {
            PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> (a.node.val - b.node.val));
            while(!q.isEmpty()) {
                pq.offer(q.poll());
            }
            while(!pq.isEmpty()) {
                Node p = pq.poll();
                TreeNode n = p.node;
                int col = p.col;
                map.putIfAbsent(col, new ArrayList<>());
                map.get(col).add(n.val);
                if(n.left != null) {
                    q.offer(new Node(n.left, col - 1));
                }
                if(n.right != null) {
                    q.offer(new Node(n.right, col + 1));
                }
            }
        }
        for(int k : map.keySet()) {
            ans.add(map.get(k));
        }
        return ans;
    }
}
