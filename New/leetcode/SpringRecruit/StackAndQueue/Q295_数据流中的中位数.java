package leetcode.SpringRecruit.StackAndQueue;

import java.util.PriorityQueue;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/13 21:49
 */
public class Q295_数据流中的中位数 {
    class MedianFinder {
        PriorityQueue<Integer> q1 = new PriorityQueue<>((a, b) -> (b - a));
        PriorityQueue<Integer> q2 = new PriorityQueue<>();
        /** initialize your data structure here. */
        public MedianFinder() {
        }
        public void addNum(int num) {
        /*
        ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian","addNum","addNum","findMedian","addNum","findMedian"]
        [[],[-2222],[222],[],[22],[],[2],[-22],[],[-222],[]]
        */
            if(q1.isEmpty() || num < q1.peek()) {
                q1.offer(num);
            } else {
                q2.offer(num);
            }
            if(q1.size() >= q2.size() + 2) {
                q2.offer(q1.poll());
            } else if(q2.size() >= q1.size() + 1) {
                q1.offer(q2.poll());
            }
        }

        public double findMedian() {
            // System.out.println(q1 + " " + q2);
            if((q1.size() + q2.size()) % 2 == 1) {
                return (double) q1.peek();
            } else {
                return (double) (q1.peek() + q2.peek()) / 2;
            }
        }
    }
}
