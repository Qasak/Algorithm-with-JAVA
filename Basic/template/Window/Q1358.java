package leetcode.template.Window;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/19 11:55
 */
public class Q1358 {
    // "aaacbabccc"
    // 从下标 i 开始的所有子串，我们按顺序从前到后考虑，一定是前部分均非法，后部分均合法
    // 通过这个性质我们知道对于下标 ii 开始的所有子串，它的合法性是随下标具有单调性的
    public int numberOfSubstrings(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] freq = new int[3];
        int distinct1 = 0;
        int l = 0, ans = 0;
        for(int r = 0; r < n; r++) {
            if(freq[cs[r] - 'a'] == 0) {
                distinct1++;
            }
            freq[cs[r] - 'a']++;
            while(l < r && distinct1 == 3) {
                ans += n - r;
                freq[cs[l] - 'a']--;
                if(freq[cs[l] - 'a'] == 0) {
                    distinct1--;
                }
                l++;
            }
        }
        return ans;
    }
}
