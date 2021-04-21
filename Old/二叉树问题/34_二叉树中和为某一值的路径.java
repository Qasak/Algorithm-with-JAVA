 // 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
/*
 先序遍历 + 路径记录
**/
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans = new ArrayList<>();
        dfs(root, 0, sum, new ArrayList<>());
        return ans;
    }
    private static final List<List<Integer>> ans;
    private void dfs(TreeNode root, int cur, int sum, List<Integer> path) {
		// 先序遍历 : 若节点 root 为空，则直接返回。
        if(root == null) {
            return;
        }
        path.add(root.val);
        cur += root.val;
		// 用例存在负数，所以不要在这里剪枝
		// if(cur > sum) {
		// 	path.remove(path.size() - 1);
		// 	return;
		// }
        if(cur == sum && root.left == null && root.right == null) {
			// 新建一个ArrayList引用 => 否则ans每个位置存的都是path这一个引用
            ans.add(new ArrayList<>(path));
        } else {
            dfs(root.left, cur, sum, path);
            dfs(root.right, cur, sum, path);
        }
		// 向上回溯前，需要将当前节点从路径 path 中删除
        path.remove(path.size() - 1);
    }
}