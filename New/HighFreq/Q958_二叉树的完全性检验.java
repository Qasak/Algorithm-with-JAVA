package leetcode.HighFreq;

import leetcode.template.Tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/30 10:19
 */
public class Q958_二叉树的完全性检验 {
    // 二叉树是否是一颗完全二叉树
    // BFS 模拟完全遍历
    public boolean isCompleteTree(TreeNode root) {
        int h = getH(root);
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;
        boolean flag = true;
        while(!q.isEmpty() && level < h) {
            int size = q.size();
            for(int i = 0 ; i < size; i++) {
                TreeNode node = q.poll();
                if(level < h - 1) {
                    if(node.left == null || node.right == null) {
                        return false;
                    }
                } else {
                    if(node.left == null) {
                        flag = false;
                    }
                    if(node.left != null) {
                        if(!flag) {
                            return false;
                        }
                    }
                    if(node.right == null) {
                        flag = false;
                    }
                    if(node.right != null) {
                        if(!flag) {
                            return false;
                        }
                    }
                }

                q.offer(node.left);
                q.offer(node.right);
            }
            level++;
        }
        return true;
    }
    private int getH(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(getH(root.left), getH(root.right)) + 1;
    }
    // 优化
    // 对于一个完全二叉树，层序遍历的过程中遇到第一个空节点之后不应该再出现非空节点
    public boolean isCompleteTree1(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean end = false;
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node != null) {
                if(end) {
                    return false;
                }
                q.offer(node.left);
                q.offer(node.right);
            } else {
                end = true;
            }

        }
        return true;
    }

    // 2. BFS编号遍历
    // (depth, position) 元组表示每个节点的”位置“
    // 对于根节点，我们定义其编号为 1。然后，对于每个节点 v，我们将其左节点编号为 2 * v，将其右节点编号为 2 * v + 1。


}
