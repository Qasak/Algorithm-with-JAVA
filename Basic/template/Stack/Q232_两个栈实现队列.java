package leetcode.template.Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/5 10:37
 */
public class Q232_两个栈实现队列 {
    class MyQueue {
        Deque<Integer> stk1;
        Deque<Integer> stk2;

        /** Initialize your data structure here. */
        public MyQueue() {
            stk1 = new LinkedList<>();
            stk2 = new LinkedList<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stk1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            int ans = 0;
            if(stk2.isEmpty()) {
                while(!stk1.isEmpty()) {
                    stk2.push(stk1.pop());
                }
            }
            ans = stk2.pop();
            return ans;
        }

        /** Get the front element. */
        public int peek() {
            if(stk2.isEmpty()) {
                while(!stk1.isEmpty()) {
                    stk2.push(stk1.pop());
                }
            }
            int ans = stk2.pop();
            stk2.push(ans);
            return ans;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stk1.isEmpty() && stk2.isEmpty();
        }
    }
}
