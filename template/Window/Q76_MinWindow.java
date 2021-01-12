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

    public static void main(String[] args) {
        int []  a = new int[128];
        System.out.println(a['a']);
    }
}
