package leetcode.SpringRecruit.Tree;

import leetcode.template.Tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/13 11:44
 */
public class Q144_二叉树前序遍历 {
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Deque<TreeNode> stk = new LinkedList<>();
            while(root != null || !stk.isEmpty()) {

                while(root != null) {
                    list.add(root.val);
                    stk.push(root);
                    root = root.left;
                }
                root = stk.pop();
                root = root.right;
            }
            return list;
        }
    }

    // 前序 根-左-右
    class Solution1 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Deque<TreeNode> stk = new LinkedList<>();
            while(root != null || !stk.isEmpty()) {
                if(root != null) {
                    list.add(root.val);
                    stk.push(root);
                    root = root.left;
                } else {
                    root = stk.pop();
                    root = root.right;
                }
            }
            return list;
        }
    }
    // 中序 左-根-右
    class Solution3 {
        private List<Integer> list;
        public List<Integer> inorderTraversal(TreeNode root) {
            list = new ArrayList<>();
            Deque<TreeNode> stk = new LinkedList<>();
            while(root != null || !stk.isEmpty()) {
                if(root != null) {
                    stk.push(root);
                    root = root.left;
                } else {
                    root = stk.pop();
                    list.add(root.val);
                    root = root.right;
                }
            }
            return list;
        }
    }
    // 后序 左-右-根 == reverse(根-右-左)
    class Solution2 {
        public List<Integer> postorderTraversal(TreeNode root) {
            // List 没有addFirst()方法
            LinkedList<Integer> list = new LinkedList<>();
            Deque<TreeNode> stk = new LinkedList<>();
            TreeNode pre = null;
            // 按照 根-右-左的方式访问，反转插入(头插)
            while(root != null || !stk.isEmpty()) {
                if(root != null) {
                    list.addFirst(root.val);
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

}
