package leetcode.template.Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/19 16:01
 */
// n 个点生成的二叉搜索树数量等价于数学上第 n 个「卡特兰数」，用 Gn 表示, Gn以O(4^n / n(3 / 2))
    // 生成一棵二叉搜索树需要 O(n)  的时间复杂度，一共有 Gn棵二叉搜索树，也就是 O(nGn)
    // 递归函数需要 O(n) 的栈空间
public class Q95 {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            return new LinkedList<TreeNode>();
        }
        return help(1, n);
    }
    private List<TreeNode> help(int l, int r) {
        List<TreeNode> ans = new LinkedList<>();
        if(l > r) {
            ans.add(null);
            return ans;
        }
        for(int i = l; i <= r; i++) {
            List<TreeNode> lTree = help(l, i - 1);
            List<TreeNode> rTree = help(i + 1, r);
            for(TreeNode left : lTree) {
                for(TreeNode right : rTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
