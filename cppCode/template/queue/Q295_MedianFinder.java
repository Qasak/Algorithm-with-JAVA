package leetcode.template.queue;

import Utils.ArrayUtil;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/3 11:44
 */
// 1. 二分插入

class MedianFinder {
    ArrayList<Double> a;
    /** initialize your data structure here. */
    public MedianFinder() {
        a = new ArrayList<>();
    }

    public void addNum(int num) {
        if(a.size() == 0) {
            a.add((double)num);
        } else {
            a.add(ArrayUtil.lowerBound(a, (double)num), (double)num);
        }
    }

    public double findMedian() {
        int n = a.size();
        return ((n % 2) == 0) ? ((a.get(n / 2) + a.get((n - 1) / 2)) / 2) : (a.get(n / 2));
    }

}
// 2. 双堆
// 思路： 把数据流分成两半，前半用大根堆q1，后半用小根堆q2
// 1. q1的元素可以比q2多一个, 奇数个元素时，直接取q1.peek(); 偶数个元素时, 取(q1.peek() + q2.peek()) / 2
// 2. 不满足性质的情况有：q1的元素比q2多两个 / q1的元素比q2少
// 3.
class MedianFinder1 {
    PriorityQueue<Integer> q1;
    PriorityQueue<Integer> q2;
    /** initialize your data structure here. */
    public MedianFinder1() {
        q1 = new PriorityQueue<>((a, b) -> b - a);
        q2 = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(q1.size() == 0) {
            q1.offer(num);
            return;
        }
        if(num > q1.peek()) {
            q2.offer(num);
        } else {
            q1.offer(num);
        }
        if(q1.size() >= q2.size() + 2) {
            q2.offer(q1.poll());
        }
        if(q1.size() < q2.size()) {
            q1.offer(q2.poll());
        }
    }

    public double findMedian() {
        if(q1.size() == q2.size()) {
            return (double) (q1.peek() + q2.peek()) / 2;
        } else {
            return (double) q1.peek();
        }
    }





    public static void main(String[] args) {
        List<Double> a = new ArrayList<>();
        //  1.0003, 1.0021, 1.0101
        a.add(1.0101);
        a.add(1.0021);
        a.add(1.0003);
        a.add(1.00001);
        a.sort((x, y) -> (x - y) < 0 ? -1 : ((x - y) == 0 ? 0 : 1));
        System.out.println(a);
    }


}
