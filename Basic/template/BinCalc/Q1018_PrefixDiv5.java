package leetcode.template.BinCalc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/14 10:44
 */
public class Q1018_PrefixDiv5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        // 101  5
        // 1111 15

        // 0 01 011 0111 01111

        // 0
        // 5 / 10 / 15/ 20 / 25

        // 101/ 1010 / 1111/ 10100/ 11001
        //


        // 如果X是二进制数组的第一个i位数，那么2X+a[i]是第一个i+1位数。
        List<Boolean> ans = new ArrayList<Boolean>();
        int pre = 0;
        int n = A.length;
        for(int i = 0; i < n; i++) {
            pre = pre * 2 + A[i];
            if(pre % 5 == 0) {
                ans.add(true);
            } else {
                ans.add(false);
            }
            pre %= 5;
        }
        return ans;
    }
}
