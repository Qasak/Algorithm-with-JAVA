package leetcode.JianZhi;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/18 8:32
 */
public class Q59_队列的最大值 {
    class MaxQueue {
        private Deque<Integer> q1;
        // 单减队列
        private Deque<Integer> q2;

        public MaxQueue() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();

        }

        public int max_value() {
            if(q2.isEmpty()) {
                return -1;
            }
            return q2.peekFirst();
        }

        public void push_back(int value) {
            q1.offer(value);
            while(!q2.isEmpty() && value > q2.peekLast()) {
                q2.pollLast();
            }
            q2.offer(value);
        }

        public int pop_front() {
            if(q1.isEmpty()) {
                return -1;
            }
            if(q1.peekFirst().equals(q2.peekFirst())) {
                q2.pollFirst();
            }
            return q1.pollFirst();
        }
    }
    public static void main(String[] args) {
        Deque<Integer> q1;
    }
}
