package leetcode.template.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/20 15:30
 */
public class Q267_PalindromePermute {
    int[] cnt;
    List<String> res;
    char single;
    public List<String> generatePalindromes(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        cnt = new int[128];
        for(char c : cs) {
            cnt[c]++;
        }
        res = new ArrayList<>();
        if(!check(cs)) {
            return res;
        }
        char[] ch = new char[n / 2];
        // aaaabbc
        // aabc
        int idx = 0;
        single = 0;
        for(int i = 0; i < 128; i++) {
            if(cnt[i] % 2 == 1) {
                single = (char)i;
            }
            for(int j = 0; j < (cnt[i]) / 2; j++) {
                ch[idx++] = (char)i;

            }
        }
        dfs(ch, 0);
        return res;
    }
    private void dfs(char[] ch, int idx) {
        int n = ch.length;
        if(idx == ch.length) {
            StringBuilder sb = new StringBuilder(String.valueOf(ch));
            String tmp = sb.toString();
            if(single != 0) {
                tmp += String.valueOf(single);
            }
            tmp += sb.reverse().toString();
            res.add(tmp);
            return;
        }

        // 1. 通过排序去重
        for(int i = idx; i < n; i++) {
            Arrays.sort(ch, idx, n);
            if(i + 1 < n && ch[i] == ch[i + 1]) {
                continue;
            }
            swap(ch, i, idx);
            dfs(ch, idx + 1);
            swap(ch, i, idx);

        }
    }
    private void swap(char[] nums, int i, int j) {
        char t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    private boolean check(char[] cs) {
        boolean flag = true;
        for(int i = 0; i < 128; i++) {
            // 奇数仅能出现一次
            if((cnt[i] & 1) == 1) {
                if(!flag) {
                    return false;
                }
                flag = false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

    }

}
