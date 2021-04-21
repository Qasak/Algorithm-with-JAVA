package leetcode.template.Window;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/6 1:08
 */
public class Q395_ {
    // 1. 分治
    // 前提：若当前子串中存在总出现次数<k的字符，该子串一定不满足题目要求
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if(n < k) {
            return 0;
        }
        char[] cs = s.toCharArray();
        int[] cnt = new int[26];
        for(char c : cs) {
            cnt[c - 'a']++;
        }
        int l = 0;
        int res = 0;
        for(int r = 0; r < n; r++) {
            if(cnt[cs[r] - 'a'] < k) {
                res = Math.max(res, longestSubstring(s.substring(l, r), k));
                l = r + 1;
            }
        }
        return l == 0 ? n : Math.max(res, longestSubstring(s.substring(l, n), k));
    }
    // 2. 滑窗
    public int longestSubstring1(String s, int k) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int ans = 0;
        // i: 窗口中允许出现的字符种数
        for(int i = 1; i <= 26; i++) {
            int[] cnt = new int[26];
            // l: 左边界 j: 当前出现的字符种数
            int l = 0, j = 0;
            for(int r = 0; r < n; r++) {
                if(cnt[cs[r] - 'a'] == 0) {
                    j++;
                }
                cnt[cs[r] - 'a']++;
                while(j > i) {
                    cnt[cs[l] - 'a']--;
                    if(cnt[cs[l] - 'a'] == 0) {
                        j--;
                    }
                    l++;
                }
                boolean flag = true;
                for(int t = 0; t < 26; t++) {
                    if(cnt[t] > 0 && cnt[t] < k) {
                        flag = false;
                    }
                }
                if(flag) {
                    ans = Math.max(ans, r - l + 1);
                }
            }
        }
        return ans;
    }
}
