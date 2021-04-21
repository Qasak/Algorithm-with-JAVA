package leetcode.template.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/8 13:34
 *
 * 输入: "1101111"
 * 输出: [110, 1, 111]
 * 解释: 输出 [11,0,11,11] 也同样被接受。
 *
 * 输入: "112358130"
 * 输出: []
 *
 *
 * 输入："0123"
 * 输出：[]
 * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
 *
 * 字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 *
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 */
public class SplitIntoFibo_842 {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans = new ArrayList<>();
        dfs(S, 0, ans);
        return ans;
    }
    // idx: 某次递归的起点位置
    public boolean dfs(String s, int idx, List<Integer> ans) {
        // 结束条件：指针指向原串末尾且答案大于等于3
        // 第一个true的来历：避开了下面所有的false条件并且抵达终点
        if(idx == s.length() && ans.size() > 2) {
            return true;
        }

        //从当前起点一直到末尾
        for(int i = idx; i < s.length(); i++) {
            // 起点为0，想要加入的元素不止0：返回false
            if(s.charAt(idx) == '0' && i > idx) {
                return false;
            }
            // 当前值从起点选单个数开始变大
            long curVal = Long.parseLong(s.substring(idx, i + 1));
            // 不超过32 位有符号整数类型
            if(curVal > Integer.MAX_VALUE) {
                return false;
            }
            int curSize = ans.size();
            if(curSize < 2 || curVal == ans.get(curSize - 1) + ans.get(curSize - 2)) {
                ans.add((int)curVal);
                // 本次选了[idx, i]这一段的数字加到ans,下次从i + 1开始
                // 链式返回true
                if(dfs(s, i + 1, ans)) {
                    return true;
                    // 否则：移除本次影响
                } else {
                    ans.remove(ans.size() - 1);
                }
            }
            // 再继续拼接只会导致curVal变大
            if(curSize >= 2 && curVal > ans.get(curSize - 1) + ans.get(curSize - 2)) {
                return false;
            }
        }
        return false;
    }
}
