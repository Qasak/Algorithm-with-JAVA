package leetcode.JianZhi;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/12 20:44
 */
// 两个栈实现队列
public class Q9 {
    class CQueue {
        Deque<Integer> stk1;
        Deque<Integer> stk2;

        public CQueue() {
            stk1 = new LinkedList<>();
            stk2 = new LinkedList<>();

        }

        public void appendTail(int value) {
            stk1.push(value);

        }

        public int deleteHead() {
            if(stk1.isEmpty()) {
                return -1;
            }
            while(!stk1.isEmpty()) {
                stk2.push(stk1.pop());
            }
            int ans = stk2.pop();
            while(!stk2.isEmpty()) {
                stk1.push(stk2.pop());
            }
            return ans;
        }
    }
}
