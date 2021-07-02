package leetcode.contest.NiceProblem.贪心技巧;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/2 11:33
 */
public class Q1833_雪糕的最大数量 {
    // dp
    public int maxIceCream(int[] costs, int coins) {
        // f[i][j] : 前i个雪糕， j块钱时能买到的最大雪糕数量
        int n = costs.length;
        int[] f = new int[coins + 1];
        for(int i = 0; i < n; i++) {
            for(int j = coins; j >= 0; j--) {
                int cost = costs[i];
                if(j >= cost) {
                    f[j] = Math.max(f[j], f[j - cost] + 1);
                }
            }
        }
        return f[coins];
    }
    // 普通排序+贪心
    public int maxIceCream1(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0;
        int i = 0, n = costs.length;
        while(i < n && coins >= costs[i]) {
            coins -= costs[i++];
            ans++;
        }
        return ans;
    }
    // 计数排序+贪心
    // 计数排序要点：下标：值 == 花费：个数
    // 对于每一个花费，判断能不能买满个数，用整数除法计算最大个数
    public int maxIceCream2(int[] costs, int coins) {
        int[] f = new int[100001];
        for(int c : costs) {
            f[c]++;
        }
        int ans = 0;
        // 下标：值 == 花费：个数
        for(int i = 1; i <= 100000; i++) {
            if(i > coins) {
                break;
            }
            int cnt = Math.min(f[i], coins / i);
            ans += cnt;
            coins -= i * cnt;
        }
        return ans;
    }
}
