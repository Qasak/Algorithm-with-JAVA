package leetcode.SpringRecruit.Tree;

import leetcode.template.Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/9 18:34
 */
public class QJZ07_重建二叉树 {
    // 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树
    // 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    /*
        前序遍历 preorder = [3,9,20,15,7]
        中序遍历 inorder = [9,3,15,20,7]
            3
           / \
          9  20
            /  \
           15   7
    * */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素

        Map<Integer, Integer> map = new HashMap<>();
        int n = preorder.length;
        for(int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return build(map, preorder, inorder, 0, n - 1, 0, n - 1);
    }
    public TreeNode build(Map<Integer, Integer> map, int[] preorder, int[] inorder, int l1, int r1, int l2, int r2) {
        if(l1 > r1 || l2 > r2) {
            return null;
        }
        int val = preorder[l1];
        TreeNode root = new TreeNode(val);
        int lSize = map.get(val) - l2;
        root.left =  build(map, preorder, inorder, l1 + 1, l1 + lSize, l2, l2 + lSize - 1);
        root.right = build(map, preorder, inorder, l1 + lSize + 1, r1, l2 + lSize + 1, r2);
        return root;
    }
    // 先序数组下标挨个增加
    class Solution {
        // 先序数组的节点下标
        int idx = 0;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
            // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素

            Map<Integer, Integer> map = new HashMap<>();
            int n = preorder.length;
            for(int i = 0; i < n; i++) {
                map.put(inorder[i], i);
            }
            return build(map, preorder, inorder, 0, n - 1);
        }
        public TreeNode build(Map<Integer, Integer> map, int[] preorder, int[] inorder, int l, int r) {
            if(l > r) {
                return null;
            }
            int val = preorder[idx++];
            TreeNode root = new TreeNode(val);
            int m = map.get(val);
            root.left =  build(map, preorder, inorder, l, m - 1);
            root.right = build(map, preorder, inorder, m + 1, r);
            return root;
        }
    }
}


