package leetcode.SpringRecruit.StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/19 19:27
 */
public class Q42_接雨水 {
    public int trap(int[] height) {
        // 单减栈
        Deque<Integer> stk = new LinkedList<>();
        int ans = 0;
        for(int i = 0; i < height.length; i++) {
            while(!stk.isEmpty() && height[i] > height[stk.peek()]) {
                // 挨个计算
                int h = height[stk.pop()];
                if(!stk.isEmpty()) {
                    ans += (Math.min(height[i], height[stk.peek()]) - h) * (i - stk.peek() - 1);
                }
            }
            stk.push(i);
        }
        return ans;
    }

    // 2. DP
}
