package leetcode.template.DP.树型DP;

import leetcode.TreeNode;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/5 19:44
 */
public class LCP34_二叉树染色 {
    int K;
    public int maxValue(TreeNode root, int k) {
        K = k;
        return Arrays.stream(dfs(root)).max().getAsInt();
    }
    int[] dfs(TreeNode root) {
        // f[i] : 当前节点相邻的所有节点，染色i个的最大值
        int[] f = new int[K + 1];
        if(root == null ) {
            return f;
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        // 不选当前节点
        f[0] = Arrays.stream(l).max().getAsInt() + Arrays.stream(r).max().getAsInt();
        // 选当前节点
        for(int i = 0; i < K; i++) {
            for(int j = 0; j + i < K; j++) {
                f[i + j + 1] = Math.max(f[i + j + 1], l[i] + r[j] + root.val);
            }
        }
        return f;
    }
    public static void main(String[] args) {
        int[] a = new int[]{};
        System.out.println(Arrays.stream(a).max().getAsInt());
    }
}
