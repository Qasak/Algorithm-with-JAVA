package leetcode.template.Tree;

import java.util.Random;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/19 12:31
 */
public class Q108 {
    // 二叉搜索树的中序遍历是升序序列
    // 时间复杂度：O(n)O(n)，其中 nn 是数组的长度。每个数字只访问一次。
    //
    //空间复杂度：O(\log n)O(logn)，其中 nn 是数组的长度。空间复杂度不考虑返回值，因此空间复杂度主要取决于递归栈的深度，递归栈的深度是 O(\log n)O(logn)。
    Random rand = new Random();
    public TreeNode sortedArrayToBST(int[] nums) {
        return help(nums, 0, nums.length - 1);
    }
    private TreeNode help(int[] nums, int l, int r) {
        if(l > r) {
            return null;
        }
        int m = (l + r + rand.nextInt(2)) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = help(nums, l, m - 1);
        root.right = help(nums, m + 1, r);
        return root;
    }
}
