package leetcode.JianZhi;

import leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/12 20:42
 */

/*
中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
* **/
public class Q106_LC {
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, n - 1, 0, n - 1);
    }
    private TreeNode build(int[] inorder, int[] postorder, int inL, int inR, int posL, int posR) {
        if(posL > posR) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[posR]);
        int inorderIdx = map.get(postorder[posR]);
        int lLength = inorderIdx - inL;
        root.left = build(inorder, postorder, inL, inorderIdx - 1, posL, posL + lLength - 1);
        root.right = build(inorder, postorder, inorderIdx + 1, inR, posL + lLength, posR - 1);
        return root;
    }
}
