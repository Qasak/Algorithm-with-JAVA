package leetcode.JianZhi;

import leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/12 17:28
 */
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    // 前序遍历 preorder = [3,9,20,15,7]
    // 中序遍历 inorder = [9,3,15,20,7]
// 根据前序和中序重建二叉树
    // 前序
    // [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
    // 中序
    // [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]

    // 只要我们在中序遍历中定位到根节点，那么我们就可以分别知道左子树和右子树中的节点数目

public class Q7 {
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) {
            return null;
        }
        map = new HashMap<>();
        int n = preorder.length;
        for(int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, n - 1, 0, n - 1);
    }
    private TreeNode build(int[] preorder, int[] inorder, int preL, int preR, int inL, int inR) {
        if(preL > preR) {
            return null;
        }
        int rootVal = preorder[preL];
        TreeNode root = new TreeNode(rootVal);
        int inorderIdx = map.get(rootVal);
        int lLength = inorderIdx - inL;
        root.left = build(preorder, inorder, preL + 1, preL + lLength, inL, inorderIdx - 1);
        root.right = build(preorder, inorder, preL + lLength + 1, preR, inorderIdx + 1, inR);
        return root;
    }
}
