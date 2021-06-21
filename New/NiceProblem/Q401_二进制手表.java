package leetcode.contest.NiceProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/21 11:20
 */
public class Q401_二进制手表 {
    // 1. 枚举
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < 12; i++) {
            for(int j = 0; j < 60; j++) {
                if(Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                    ans.add(String.valueOf(i) + ":" + String.format("%02d", j));
                }
            }
        }
        return ans;
    }
    // 2. 组合
    int[] nums = new int[]{1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
    List<String> ans = new ArrayList<>();
    public List<String> readBinaryWatch1(int turnedOn) {
        dfs(0, 0, 0, 0, turnedOn);
        return ans;
    }
    public void dfs(int idx, int h, int m, int cnt, int turnedOn) {
        if(h > 11 || m > 59) {
            return;
        }
        if(cnt == turnedOn) {
            StringBuilder tmp = new StringBuilder();
            tmp.append(h).append(":");
            if(m < 10) {
                tmp.append("0");
            }
            tmp.append(m);
            ans.add(tmp.toString());
            return;
        }
        for(int i = idx; i < nums.length; i++) {
            if(i < 4) {
                dfs(i + 1, h + nums[i], m, cnt + 1, turnedOn);
            } else {
                dfs(i + 1, h, m + nums[i], cnt + 1, turnedOn);
            }
        }
    }
    public static void main(String[] args) {
        int m = 33;
        System.out.println(String.format("%02d", m));
    }
}
