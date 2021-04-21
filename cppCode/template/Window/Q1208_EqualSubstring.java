package leetcode.template.Window;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/5 17:50
 */
public class Q1208_EqualSubstring {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int n = cs.length;
        int[] cost = new int[n];
        for(int i = 0; i < n; i++) {
            cost[i] = Math.abs(cs[i] - ct[i]);
        }
        int sum = 0;
        int l = 0;
        int ans = 0;
        for(int r = 0; r < n ; r++) {
            sum += cost[r];
            if(sum <= maxCost) {
                ans = Math.max(ans, r - l + 1);
            } else {
                sum -= cost[l];
                l++;
            }
        }
        return ans;
    }
}
