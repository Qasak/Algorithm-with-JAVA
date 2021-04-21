package leetcode.template.Simulation;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/25 17:20
 */
public class Q1737_MinCharacters {
    public int minCharacters(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[] ca = new int[26];
        int[] cb = new int[26];
        for(int i = 0; i < n; i++) {
            ca[a.charAt(i) - 'a']++;
        }
        for(int i = 0; i < m; i++) {
            cb[b.charAt(i) - 'a']++;
        }
        int ans = n + m;
        // 情况3
        for(int i = 0; i < 26; i++) {
            // 相同的就不用改
            ans = Math.min(ans, n + m - ca[i] - cb[i]);
        }

        for(int i = 1; i < 26; i++) {
            ca[i] = ca[i] + ca[i - 1];
            cb[i] = cb[i] + cb[i - 1];
        }
        for(int i = 0; i < 25; i++) {
            // 情况1  a < b：
            //        将a中所有大于临界字母的改成临界字母 : 大于临界字母的个数：n - ca[i]
            //        将b中所有小于等于临界字母的改成大于临界字母 : 小于等于临界字母的个数：cb[i]

            // b中字母不能比z大，临界字母为z时，b不能再改，所以不能取到z
            ans = Math.min(ans, n - ca[i] + cb[i]);
            ans = Math.min(ans, ca[i] + m - cb[i]);
        }
        return ans;
    }
}
