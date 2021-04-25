package leetcode.SpringRecruit.Tree;

import leetcode.template.Tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/13 10:08
 */
public class Q230_二叉搜索树中的第K小元素 {
    // 对于一棵BST 其查找/插入/删除元素的平均时间复杂度是O(h) / O(logN)

    // 如果频繁删除添加节点，可以维护每个节点的左右孩子个数，
    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            int cnt = k - 1;
            Deque<TreeNode> stk = new LinkedList<>();
            while(root != null || !stk.isEmpty()) {
                while(root != null) {
                    stk.push(root);
                    root = root.left;
                }
                root = stk.pop();
                if(cnt == 0) {
                    return root.val;
                }
                cnt--;
                root = root.right;
            }
            return -1;
        }
    }
}
