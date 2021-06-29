package leetcode.contest.Week_247;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/28 22:05
 */
public class Q1915_最美子字符串的数目 {
    public long wonderfulSubstrings(String word) {
        // 全是偶数
        // 有一个奇数
        // 有两个或以上个奇数
        int n = word.length();
        int[] cnt = new int[1024];
        cnt[0] = 1;
        int mask = 0;
        char[] cs = word.toCharArray();
        long ans = 0;
        for(int i = 0; i < n; i++) {
            mask ^= 1 << (cs[i] - 'a');
            ans += cnt[mask];
            for(int j = 0; j < 10; j++) {
                ans += cnt[mask ^ (1 << j)];
            }
            cnt[mask]++;
        }
        return ans;
    }
}
