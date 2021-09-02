class Solution {
    Map<TreeNode, Integer> f;
    Map<TreeNode, Integer> g;
    public int rob(TreeNode root) {
        if(root == null) {
            return 0;
        }
        f = new HashMap<>();
        g = new HashMap<>();
        dfs(root);
        return Math.max(f.get(root), g.get(root));
    }
    void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        f.put(root, root.val + g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0));
        g.put(root, Math.max(g.getOrDefault(root.left, 0), f.getOrDefault(root.left, 0)) + Math.max(g.getOrDefault(root.right, 0), f.getOrDefault(root.right, 0)));
    }
}

// 空间优化
class Solution {
    public int rob(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int[] t = dfs(root);
        return Math.max(t[0], t[1]);
    }
    int[] dfs(TreeNode root) {
        if(root == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int a = root.val + l[1] + r[1];
        int b = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{a, b};
    }
}