package leetcode.contest.NiceProblem;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/22 14:46
 */
public class Q38_JZ_字符串的排列 {
    // 输入有重复元素时，输出不能重复
    // 时间复杂度：O(n \times n!)O(n×n!)，其中 nn 为给定字符串的长度。这些字符的全部排列有 O(n!)O(n!) 个，每个排列平均需要 O(n)O(n) 的时间来生成。
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
            // abbbc
            // 只添加最左边的b
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
// 不断调用nextPermutation
class Solution1 {
    List<String> res = new ArrayList<>();
    boolean[] vis;
    public String[] permutation(String s) {
        vis = new boolean[s.length()];
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        res.add(new String(cs));
        while(nextPermutation(cs)) {
            res.add(new String(cs));
        }
        String[] ans = new String[res.size()];
        int idx = 0;
        for(String ss : res) {
            ans[idx++] = ss;
        }
        return ans;
    }

    public boolean nextPermutation(char[] nums) {
        int n = nums.length;
        if(n == 1) {
            return false;
        }
        int i = n - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if(i < 0) {
            Arrays.sort(nums);
            return false;
        }
        int j = n - 1;
        while(j > i && nums[j] <= nums[i]) {
            j--;
        }
        swap(nums, i, j);
        Arrays.sort(nums, i + 1, n);
        return true;
    }
    public void swap(char[] nums, int i, int j) {
        char t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}