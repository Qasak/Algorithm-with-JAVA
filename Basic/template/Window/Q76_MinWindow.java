package leetcode.template.Window;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/12 16:26
 */
public class Q76_MinWindow {
    // 暴力检查
    boolean check(int[] win, int[] tt, char[] t) {
        for(char c : t) {
            if(win[c] - tt[c] < 0) {
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int n = s.length();
        int l = 0;
        int x = 0, y = n - 1;
        int len = n;
        int[] cnt = new int[128];
        int[] tt = new int[128];
        char[] cs = t.toCharArray();
        boolean flag = false;
        for(char c: cs) {
            tt[c]++;
        }
        for(int r = 0; r < n; r++) {
            // 窗口中包含所有的t的字符, l++
            // 计算最小值
            cnt[s.charAt(r)]++;
            while(check(cnt, tt, cs)) {
                flag = true;
                if(r - l + 1 < len) {
                    x = l;
                    y = r;
                    len = r - l + 1;
                }
                cnt[s.charAt(l++)]--;
            }
        }

        return !flag ? "" : s.substring(x, y + 1);
    }
    // 用一个变量做标识符
    public String minWindow1(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();

        int n = cs.length;
        int m = ct.length;
        int[] cnt1 = new int[128];
        int[] cnt2 = new int[128];

        for (char c : ct) {
            cnt2[c]++;
        }
        int l = 0;
        int len = n;
        int x = 0, y = n - 1;
        // 还需要多少个字符
        int need = m;
        boolean flag = false;
        // 扫s字符串
        for(int r = 0; r < n; r++) {
            // 不是t中的字符直接忽略
            char cur = cs[r];
            if(cnt2[cur] == 0) {
                continue;
            }
            // 拿到一个需要的字符, 还需要need - 1 个
            if(cnt1[cur] < cnt2[cur]) {
                need--;
            }
            cnt1[cur]++;
            // 还需要0个，收缩左边
            while(need == 0) {
                flag = true;
                if(r - l + 1 < len) {
                    len = r - l + 1;
                    x = l;
                    y = r;
                }
                if(cnt1[cs[l]] > 0) {
                    cnt1[cs[l]]--;
                    if(cnt1[cs[l]] < cnt2[cs[l]]) {
                        need++;
                    }
                }
                l++;
            }
        }
        return !flag ? "" : s.substring(x, y + 1);
    }
    public static void main(String[] args) {
        int []  a = new int[128];
        System.out.println(a['a']);
    }
}
