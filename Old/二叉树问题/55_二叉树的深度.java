/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 
 /**
 关键点： 此树的深度和其左（右）子树的深度之间的关系。
 显然，此树的深度 等于 左子树的深度 与 右子树的深度 中的 最大值 +1。

 */
 // dfs(后序遍历)
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int l, r;
        l = maxDepth(root.left);
        r = maxDepth(root.right);
        return Math.max(l, r) + 1;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
// 非递归写法
// BFS

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if(tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if(tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            res++;
        }
        return res;
    }
}

