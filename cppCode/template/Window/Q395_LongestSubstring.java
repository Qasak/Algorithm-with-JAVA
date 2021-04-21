package leetcode.template.Window;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/5 18:05
 */
public class Q395_LongestSubstring {
    // 分治
    // k = 2
    // "aaabaaaacaaaaadaaaaaaaaeaa"
    public int longestSubstring(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int res = 0;
        int[] cnt = new int[26];
        for(int r = 0; r < n; r++) {
            cnt[cs[r] - 'a']++;
        }
        int l = 0;
        boolean flag = true;
        for(int r = 0; r < n; r++) {
            if(cnt[cs[r] - 'a'] < k) {
                res = Math.max(res, longestSubstring(s.substring(l, r), k));
                l = r + 1;
                flag = false;
            }
        }
        return flag ? n : Math.max(res, longestSubstring(s.substring(l, n), k));
    }
    // 迭代
    public int longestSubstring1(String s, int k) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int ans = 0;
        // i:窗口中允许出现的字符种数
        for(int i = 1; i <= 26; i++) {
            int[] cnt = new int[26];
            // l:左边界 / j:当前出现的字符种数
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
                if(check(cnt, k)) {
                    ans = Math.max(ans, r - l + 1);
                }
            }
        }
        return ans;
    }
    public boolean check(int[] cnt, int k) {
        for(int t = 0; t < 26; t++) {
            if(cnt[t] > 0 && cnt[t] < k) {
                return false;
            }
        }
        return true;
    }

    public int longestSubstring2(String s, int k) {
        int n = s.length();
        return dfs(s, 0, n - 1, k);
    }
    public int dfs(String s, int l, int r, int k) {
        if(l > r) {
            return 0;
        }
        int[] cnt = new int[26];
        for(int i = l; i <= r; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        int idx = -1;
        for(int i = l; i <= r; i++) {
            if(cnt[s.charAt(i) - 'a'] > 0 && cnt[s.charAt(i) - 'a'] < k) {
                idx = i;
                break;
            }
        }
        if(idx == -1) {
            return r - l + 1;
        }
        // idx 指向第一个不能在窗口中出现的元素
        char split = s.charAt(idx);
        int start = l;
        int ret = 0;
        int i = l;
        while(i <= r) {
            while(i <= r && s.charAt(i) == split) {
                i++;
            }
            start = i;
            while(i <= r && s.charAt(i) != split) {
                i++;
            }
            ret = Math.max(ret, dfs(s, start, i - 1, k));
        }
        return ret;
        // return Math.max(dfs(s, l, idx - 1, k), dfs(s, idx + 1, r, k));
    }

}
