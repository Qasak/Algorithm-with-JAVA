package leetcode.contest.NiceProblem;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/22 14:46
 */
public class Q38_JZ_字符串的排列 {
    // 输入有重复元素时，输出不能重复
    Set<String> res = new HashSet<>();
    boolean[] vis;
    public String[] permutation(String s) {
        vis = new boolean[s.length()];
        dfs(new StringBuilder(), s.toCharArray());
        String[] ans = new String[res.size()];
        int idx = 0;
        for(String ss : res) {
            ans[idx++] = ss;
        }
        return ans;
    }
    public void dfs(StringBuilder tmp, char[] arr) {
        if(tmp.length() == arr.length) {
            res.add(tmp.toString());
            return;
        }
        int len = tmp.length();
        for(int i = 0; i < arr.length; i++) {
            if(vis[i]) {
                continue;
            }
            vis[i] = true;
            tmp.append(arr[i]);
            dfs(tmp, arr);
            tmp.setLength(len);
            vis[i] = false;
        }
    }
}

class Solution {
    // 排序去重
    List<String> res = new ArrayList<>();
    boolean[] vis;
    public String[] permutation(String s) {
        vis = new boolean[s.length()];
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        dfs(new StringBuilder(), cs);
        String[] ans = new String[res.size()];
        int idx = 0;
        for(String ss : res) {
            ans[idx++] = ss;
        }
        return ans;
    }
    public void dfs(StringBuilder tmp, char[] arr) {

        if(tmp.length() == arr.length) {
            res.add(tmp.toString());
            return;
        }
        int len = tmp.length();
        for(int i = 0; i < arr.length; i++) {
            // 去重
            if(vis[i] || ( i > 0 && !vis[i - 1] && arr[i - 1] == arr[i]) ) {
                continue;
            }
            vis[i] = true;
            tmp.append(arr[i]);
            dfs(tmp, arr);
            tmp.setLength(len);
            vis[i] = false;
        }
    }
}
