package leetcode.SpringRecruit.StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/24 10:06
 */
public class Q456_132模式 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if(n < 3) {
            return false;
        }
        // stk单增栈, 每次可找到某个3对应可以取到的最大的2
        int two = Integer.MIN_VALUE;
        Deque<Integer> stk = new LinkedList<>();
        for(int i = n - 1; i >= 0; i--) {
            if(nums[i] < two) {
                return true;
            }
            while(!stk.isEmpty() && nums[i] > stk.peek()) {
                two = stk.pop();
            }
            stk.push(nums[i]);
        }
        return false;
    }
}
