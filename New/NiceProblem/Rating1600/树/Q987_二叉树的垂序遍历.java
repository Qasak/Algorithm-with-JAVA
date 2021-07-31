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
        public TreeNode node;
        public int col;
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
        TreeMap<Integer, List<TreeNode>> map = new TreeMap<>();
        // PriorityQueue<Node> q = new PriorityQueue<Node>((a, b) -> (a.node.val - b.node.val));
        Deque<Node> q = new LinkedList<>();
        q.offer(new Node(root, 0));
        while(!q.isEmpty()) {
            PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> (a.node.val - b.node.val));
            while(!q.isEmpty()) {
                pq.offer(q.poll());
            }
            while(!pq.isEmpty()) {
                //当前层的 col : nodes
                Node p = pq.poll();
                TreeNode n = p.node;
                int col = p.col;

                // System.out.println(n.val);
                map.putIfAbsent(col, new ArrayList<TreeNode>());
                map.get(col).add(n);
                if(n.left != null) {
                    // System.out.println(n.left.val);
                    q.offer(new Node(n.left, col - 1));
                }
                if(n.right != null) {
                    // System.out.println(n.right.val);

                    q.offer(new Node(n.right, col + 1));
                }
            }
        }
        for(int k : map.keySet()) {
            List<TreeNode> list = map.get(k);
            List<Integer> tmp = new ArrayList<>();

            for(TreeNode n  : list) {
                tmp.add(n.val);
            }
            ans.add(tmp);
        }
        return ans;
    }
}
