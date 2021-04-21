package leetcode.template.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/11 21:14
 */
public class Q93_复原IP地址 {
    List<String> ans;
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        ans = new ArrayList<>();
        if(n < 4 || n > 12) {
            return ans;
        }
        dfs(s, new StringBuilder(), 0, 0);
        return ans;
    }
    public void dfs(String s, StringBuilder cur, int idx, int dot) {
        int n = s.length();
        int len = cur.length();
        if(idx == n && dot == 4) {
            ans.add(cur.toString());
            return;
        }
        for(int i = idx; i < n; i++) {
            String tmp = s.substring(idx, i + 1);
            if((tmp.length() > 3) ||
                    ((tmp.length() > 1 && tmp.charAt(0) == '0') ||
                            (Integer.valueOf(tmp) > 255) )) {
                continue;
            }
            cur.append(tmp);
            if(i != n - 1) {
                cur.append(".");
            }
            dfs(s, cur, i + 1, dot + 1);
            cur.setLength(len);
        }
    }

    public static void main(String[] args) {
        System.out.println(8 & -8);
    }

}
