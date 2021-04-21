package leetcode.template.Stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/5 10:38
 */
public class Q225_用两个队列实现栈 {
    class MyStack {
        Deque<Integer> q1;
        Deque<Integer> q2;
        /** Initialize your data structure here. */
        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            q2.offer(x);
            while(!q1.isEmpty()) {
                q2.offer(q1.poll());
            }
            while(!q2.isEmpty()) {
                q1.offer(q2.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return q1.poll();
        }

        /** Get the top element. */
        public int top() {
            return q1.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty();
        }
    }


    class MyStack1 {
        Queue<Integer> queue;
        public MyStack1() {
            queue = new LinkedList<>();
        }
        public void push(int x) {
            int n = queue.size();
            queue.offer(x);
            for(int i = 0; i < n; i++) {
                queue.offer(queue.poll());
            }
        }
        public int pop() {
            return queue.poll();
        }
        public int top() {
            return queue.peek();
        }
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
