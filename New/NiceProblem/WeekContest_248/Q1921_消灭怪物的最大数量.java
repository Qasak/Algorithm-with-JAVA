package leetcode.contest.WeekContest_248;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/7 9:09
 */
public class Q1921_消灭怪物的最大数量 {
    // 贪心
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] tmp = new int[n];
        for(int i = 0; i < n; i++) {
            tmp[i] = dist[i] / speed[i];
            if(dist[i] > speed[i] && dist[i] % speed[i] != 0) {
                tmp[i]++;
            }
        }
        int ans = 1;
        Arrays.sort(tmp);
        for(int i = 1; i < n; i++) {
            if(tmp[i] <= i) {
                break;
            }
            ans++;
        }
        return ans;
    }
}
