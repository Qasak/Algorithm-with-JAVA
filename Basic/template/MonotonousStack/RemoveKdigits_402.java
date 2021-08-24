package leetcode.template.MonotonousStack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/2 13:24
 *
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 */
public class RemoveKdigits_402 {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(n == k) {
            return "0";
        }

        StringBuilder sb = new StringBuilder(num);
        // 找到第一个比后面大的数字，并将其删除
        // 1234 -> 234/134/124/123
        // 4312 -> 312/412/432/431
        for(int i = 0; i < k; i++) {
            int idx = 0;
            for(int j = 1; j < n && sb.charAt(j) > sb.charAt(j - 1); j++) {
                idx = j;
            }
            sb.delete(idx, idx + 1);
            // 1001 -> 001 -> 1
            // 000 -> 0
            while(sb.length() > 1 && sb.charAt(0) == '0') {
                sb.delete(0, 1);
            }
        }
        return sb.toString();
    }
    /**
     * 靠前的数字尽可能小
     * 单调栈:从左到右单增
     * */
    public static String removeKdigits1(String num, int k) {
        // 维护一个单增栈deque， 最多操作k次
        Deque<Character> deque = new LinkedList<>();
        int n = num.length();
        // 4 3 2 1
        // 3 2 1



        for(int i = 0; i < n; i++) {
            char c = num.charAt(i);
            while(!deque.isEmpty() && k > 0 && deque.peek() > c) {
                deque.pop();
                k--;
            }
            deque.push(c);
        }
        // 1 2 3 4
        // -> k = 1
        // 1 2 3
        // 如果没有达到操作的次数k，从尾部删除剩下需要操作的次数个元素
        for(int i = 0; i < k; i++) {
            deque.pop();
        }
        // 删除前导0
        // 1 0 0 1
        // 0 0 1
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        while(!deque.isEmpty()) {
            char c = deque.pollLast();
            if(flag && c == '0') {
                continue;
            }
            flag = false;
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        String[] strings = str.split(" ");
//        String s = strings[0];
//        int k = Integer.parseInt(strings[1]);
        String s1 = "1234";
        int k1 = 1;
        System.out.println(RemoveKdigits_402.removeKdigits1(s1, k1));
    }

}
