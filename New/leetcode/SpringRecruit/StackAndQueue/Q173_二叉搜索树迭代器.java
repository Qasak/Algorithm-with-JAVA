package leetcode.SpringRecruit.StackAndQueue;

import leetcode.template.Tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/28 0:33
 */
public class Q173_二叉搜索树迭代器 {
    class BSTIterator {
        private TreeNode p;
        private Deque<TreeNode> stk;
        public BSTIterator(TreeNode root) {
            stk = new LinkedList<>();
            p = root;
        }

        public int next() {
            while(p != null) {
                stk.push(p);
                p = p.left;
            }
            p = stk.pop();
            int ret = p.val;
            p = p.right;
            return ret;
        }

        public boolean hasNext() {
            return p != null || !stk.isEmpty();
        }
    }
}
