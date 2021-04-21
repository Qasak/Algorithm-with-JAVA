package leetcode.SpringRecruit.LinkedList;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/23 19:54
 */
public class Q147_链表插入排序 {
    public static void main(String[] args) {
        Deque<Integer> stk = new LinkedList<Integer>();
        Deque<Integer> stk1 = new LinkedList<Integer>();
        stk.offer(1);
        stk.offer(2);
        stk1.push(1);
        stk1.push(2);
        System.out.println(stk);
        System.out.println(stk1);

    }
}
