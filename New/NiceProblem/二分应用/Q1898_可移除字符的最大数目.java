package leetcode.contest.NiceProblem.二分应用;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/30 17:52
 */
public class Q1898_可移除字符的最大数目 {
    // 判断字符串是另一个的子序列：双指针O(n + m)
    public int maximumRemovals(String s, String p, int[] removable) {
        int k = 0;
        int n = removable.length;
        int l = 0, r = n;
        while(l < r) {
            int m = (l + r) >>> 1;
            if(check(s, p, m + 1, removable)) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
    // 使用标记来表示删除
    public boolean check(String s, String t, int k, int[] removable) {
        int n = s.length();
        int m = t.length();
        int i = 0, j = 0;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        boolean[] state = new boolean[n];
        for(int p = 0; p < k; p++) {
            state[removable[p]] = true;
        }
        while(i < n && j < m) {
            if(!state[i] && cs[i] == ct[j]) {
                i++;j++;
            } else {
                i++;
            }
        }
        return j == m;
    }

}
