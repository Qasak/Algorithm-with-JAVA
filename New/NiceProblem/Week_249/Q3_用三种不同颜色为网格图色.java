package leetcode.contest.Week_249;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/11 23:40
 */
public class Q3_用三种不同颜色为网格图色 {
    static final int MOD = (int) (1e9 + 7);
    public void dfs(int m, List<List<Integer>> types, List<Integer> path) {
        if(path.size() == m) {
            types.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < 3; i++) {
            if(path.size() == 0 || path.get(path.size() - 1) != i) {
                path.add(i);
                dfs(m, types, path);
                path.remove(path.size() - 1);
            }
        }
    }
    private boolean check(List<List<Integer>> types, int j, int k, int m) {
        for(int i = 0; i < m; i++) {
            if(types.get(j).get(i) == types.get(k).get(i)) {
                return false;
            }
        }
        return true;
    }
    public int colorTheGrid(int m, int n) {
        List<List<Integer>> types = new ArrayList<>();
        dfs(m, types, new ArrayList<Integer>());
        // System.out.println(types);
        int typeCnt = types.size();
        // 递推数组
        // f[i][j] : 第i列类型为k时的方案数
        int[][] f = new int[n + 1][typeCnt];
        // 边界情况，第一列可以使用任何 type
        for (int i = 0; i < typeCnt; ++i) {
            f[1][i] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j < typeCnt; ++j) {
                for (int k = 0; k < typeCnt; ++k) {
                    // f[i][j] 等于所有 f[i - 1][k] 的和
                    // 其中 k 和 j 可以作为相邻的列
                    if (check(types, j, k, m)) {
                        f[i][j] += f[i - 1][k];
                        f[i][j] %= MOD;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < typeCnt; ++i) {
            ans += f[n][i];
            ans %= MOD;
        }
        return ans;
    }
}
