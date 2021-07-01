package leetcode.contest.NiceProblem.回溯技巧;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/1 11:51
 */
public class QLCP07_传递信息 {
    private int ans = 0;
    public int numWays(int n, int[][] relation, int k) {
        int len = relation.length;
        for(int i = 0; i < len; i++) {
            if(relation[i][0] == 0) {
                dfs(relation, i, n, k - 1);
            }
        }
        return ans;
    }
    public void dfs(int[][] relation, int i, int n, int k) {
        if(k == 0) {
            if(relation[i][1] == n - 1) {
                ans++;
            }
            return;
        }
        for(int j = 0; j < relation.length; j++) {
            if(relation[j][0] == relation[i][1]) {
                dfs(relation, j, n, k - 1);
            }
        }
    }
}
