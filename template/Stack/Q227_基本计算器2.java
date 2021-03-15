package leetcode.template.Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/10 9:46
 */
public class Q227_基本计算器2 {
    public int calculate(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int i = 0;
        Deque<Integer> nums = new LinkedList<>();
        Deque<Character> ops = new LinkedList<>();
        boolean flag = false;
        while(i < n) {
            if(cs[i] == ' ') {
                i++;
            } else if(cs[i] == '+' || cs[i] == '-') {
                if(nums.size() == 2) {
                    char op = ops.pop();
                    if(op == '+') {
                        nums.push(nums.pop() + nums.pop());
                    } else {
                        nums.push(-nums.pop() + nums.pop());
                    }
                }
                ops.push(cs[i]);
                i++;
            } else if(cs[i] == '*' || cs[i] == '/') {
                flag = true;
                ops.push(cs[i]);
                i++;
            } else {
                int cur = 0;
                while(i < n && cs[i] >= '0' && cs[i] <= '9') {
                    cur = cur * 10 + (cs[i] - '0');
                    i++;
                }
                if(!flag) {
                    nums.push(cur);
                } else {
                    char op = ops.pop();
                    if(op == '*') {
                        nums.push(nums.pop() * cur);
                    } else {
                        nums.push(nums.pop() / cur);
                    }
                    flag = false;
                }
            }
        }
        while(!ops.isEmpty()) {
            char op = ops.pop();
            if(op == '+') {
                nums.push(nums.pop() + nums.pop());
            } else {
                nums.push(-nums.pop() + nums.pop());
            }
        }
        return nums.pop();
    }
}
