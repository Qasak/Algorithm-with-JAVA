package leetcode.contest.NiceProblem.前缀和技巧;

import java.util.TreeSet;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/8 15:39
 */
public class Q1878_矩形中最大的三个菱形和 {
    // 暴力枚举
    public int[] getBiggestThree(int[][] grid) {
        TreeSet<Integer> set = new TreeSet<>((a, b) -> b - a);
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int len = 0; len < Math.min(m, n) / 2 + 1; len++) {
                    if(i + len >= n || j + len >= m || i - len < 0 || j - len < 0) {
                        break;
                    }
                    int sum = 0;
                    if(len == 0) {
                        sum = grid[i][j];
                    } else {
                        for(int k = 0; k <= len; k++) {
                            sum += grid[i - k][j + len - k];
                            sum += grid[i + k][j + len - k];
                            sum += grid[i - k][j - (len - k)];
                            sum += grid[i + k][j - (len - k)];
                        }
                        sum -= grid[i - len][j];
                        sum -= grid[i + len][j];
                        sum -= grid[i][j + len];
                        sum -= grid[i][j - len];
                    }
                    set.add(sum);
                }
            }
        }
        int cnt = Math.min(3, set.size());
        int[] ans = new int[cnt];
        int idx = 0;
        for(int i = 0; i < cnt; i++) {
            ans[i] = set.pollFirst();
        }
        return ans;
    }
    // 前缀和

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>((a, b) -> b - a);
        set.pollFirst();
    }
}
