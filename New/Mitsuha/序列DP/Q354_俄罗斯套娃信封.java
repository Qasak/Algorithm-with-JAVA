package Mitsuha.序列DP;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/11 12:17
 */
public class Q354_俄罗斯套娃信封 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        int n = envelopes.length;
        // f[i]: i前最多有多少个套娃
        int[] f = new int[n];
        Arrays.fill(f, 1);
        int ans = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
                ans = Math.max(ans, f[i]);
            }
        }
        return ans;
    }
}
