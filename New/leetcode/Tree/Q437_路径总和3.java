package leetcode.template.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/5 16:51
 */
public class Q437_路径总和3 {
    int ans;
    public int pathSum(TreeNode root, int sum) {
        ans = 0;
        dfs(root, new ArrayList<>(), sum);
        return ans;
    }
    public void dfs(TreeNode root, List<Integer> list, int sum) {
        if(root == null) {
            return;
        }
        int m = list.size();
        int[] pre = new int[m + 1];
        for(int i = 0; i < m; i++) {
            pre[i + 1] = pre[i] + list.get(i);
        }
        for(int i = 0; i < m; i++) {
            if(root.val + pre[m] - pre[i] == sum) {
                ans++;
            }
        }
        if(root.val == sum) {
            ans++;
        }
        list.add(root.val);
        dfs(root.left, list, sum);
        dfs(root.right, list, sum);
        list.remove(list.size() - 1);
    }
}
