package leetcode.template.BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/1 17:39
 */
public class Q89_GrayCode {
    //给定编码总位数为 n 的格雷编码序列，其长度为 2^n。当 n = 0 时，长度为 20 = 1。
    //当 n = 0 时，其格雷编码序列为 [0]。
    // 任意两个相邻数的代码只有一位二进制数不同的编码
    List<Integer> ans;
    public List<Integer> grayCode(int n) {
        // 000 -> (001, 010, 100)
        ans =  new ArrayList<Integer>();
        ans.add(0);
        boolean[] vis = new boolean[(1 << n)];
        dfs(vis, ans, 0, n);
        return ans;
    }
    public boolean dfs(boolean[] vis, List<Integer> ans, int cur, int n) {
        if(ans.size() == (1 << n)) {
            return true;
        }
        vis[cur] = true;
        for(int mask = 1; mask < (1 << n); mask <<= 1) {
            if(!vis[cur ^ mask]) {
                ans.add(cur ^ mask);
                if(dfs(vis, ans, cur ^ mask, n)) {
                    return true;
                }
                ans.remove(ans.size() - 1);
            }
        }
        return false;
    }

    // 正向生成
    public List<Integer> grayCode1(int n) {
        /**
         关键是搞清楚格雷编码的生成过程, G(i) = i ^ (i >> 1);
         如 n = 3:
         G(0) = 000,
         G(1) = 1 ^ 0 = 001 ^ 000 = 001
         G(2) = 2 ^ 1 = 010 ^ 001 = 011
         G(3) = 3 ^ 1 = 011 ^ 001 = 010
         G(4) = 4 ^ 2 = 100 ^ 010 = 110
         G(5) = 5 ^ 2 = 101 ^ 010 = 111
         G(6) = 6 ^ 3 = 110 ^ 011 = 101
         G(7) = 7 ^ 3 = 111 ^ 011 = 100
         **/
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < (1 << n); ++i) {
            ret.add(i ^ (i >> 1));
        }
        return ret;
    }
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int[] a = new int[]{0,1,3,2,6,7,5,4};
        for(int i : a) {
            System.out.println(Integer.toBinaryString(i));
        }
    }
}
