package leetcode.SpringRecruit.Tree;

import leetcode.template.Tree.TreeNode;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/13 11:45
 */
public class Q145_二叉树后序遍历 {
    // 非递归
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        //
        TreeNode pre = null;
        while(root != null || !stk.isEmpty()) {
            while(root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            // 左 右 中

            // 首先 当前节点是没有左节点的 如果也没有右节点 那么它是一个叶子节点，访问之
            // 其次 若有右节点，则入栈
            // 中间节点的判定： 当前节点无右节点 / 当前节点的右节点是上次的节点
            // 如果是中间节点，访问后置位空
            // 不是中间节点，放回去，再往右走
            if(root.right == null || root.right == pre) {
                list.add(root.val);
                pre = root;
                root = null;
            } else {
                stk.push(root);
                root = root.right;
            }

        }
        return list;
    }
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            // List 没有addFirst()方法
            LinkedList<Integer> list = new LinkedList<>();
            Deque<TreeNode> stk = new LinkedList<>();
            TreeNode pre = null;
            // 按照 根-右-左的方式访问，反转插入(头插)
            while(root != null || !stk.isEmpty()) {
                if(root != null) {
                    list.add(0, root.val);
                    stk.push(root);
                    root = root.right;
                } else {
                    root = stk.pop();
                    root = root.left;
                }
            }
            return list;
        }
    }
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
    }
}
