package leetcode.template.BackTracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/11 12:03
 */
public class Q282_给表达式添加运算符 {
    List<String> ans;
    int len;
    int S;
    public List<String> addOperators(String num, int target) {
        ans = new ArrayList<>();
        len = num.length();
        S = target;
        dfs(0, 0, 0, "", num);
        return ans;
    }
    public void dfs(int idx, long cur, long diff, String exp, String num) {
        System.out.println(exp + " " + cur + " " + diff);
        if(idx == len) {
            if(cur == S) {
                ans.add(exp);
            }
            return;
        }
        for(int i = idx; i < len; i++) {
            String tmp = num.substring(idx, i + 1);
            if (tmp.length() > 1 && tmp.charAt(0) == '0') {
                break;
            }
            if (exp.length() > 0) {
                dfs(i + 1, cur + Long.valueOf(tmp), Long.valueOf(tmp), exp + "+" + tmp, num);
                dfs(i + 1, cur - Long.valueOf(tmp), -Long.valueOf(tmp), exp + "-" + tmp, num);
                // (3) * 4 * 5
                //

                dfs(i + 1, diff * Long.valueOf(tmp) + cur - diff, diff * Long.valueOf(tmp), exp + "*" + tmp, num);
            } else {
                dfs(i + 1, Long.valueOf(tmp), Long.valueOf(tmp), tmp, num);
            }
        }
    }
    public List<String> addOperators1(String num, int target) {
        ans = new ArrayList<>();
        len = num.length();
        if(len == 0) {
            return ans;
        }
        S = target;
        dfs(0,  "", num);
        return ans;
    }
    public long caculate(String exp) {
        Deque<Long> stk = new LinkedList<>();
        Deque<Character> ops = new LinkedList<>();

        char[] cs = exp.toCharArray();
        int n = cs.length;
        boolean flag = false;
        for(int i = 0; i < n; ) {
            if(cs[i] == '+' || cs[i] == '-') {
                if(stk.size() == 2) {
                    char ch = ops.pop();
                    if(ch == '+') {
                        stk.push(stk.pop() + stk.pop());
                    } else {
                        stk.push(-stk.pop() + stk.pop());
                    }
                }
                ops.push(cs[i]);
                i++;
            } else if(cs[i] == '*') {
                flag = true;
                i++;
            } else {
                long num = 0;
                while(i < n && cs[i] >= '0' && cs[i] <= '9') {
                    num = num * 10 + (cs[i] - '0');
                    i++;
                }
                if(flag) {
                    stk.push(num * stk.pop());
                    flag = false;
                } else {
                    stk.push(num);
                }
            }

        }
        while(!ops.isEmpty()) {
            char ch = ops.pop();
            if(ch == '+') {
                stk.push(stk.pop() + stk.pop());
            } else {
                stk.push(-stk.pop() + stk.pop());
            }
        }
        return stk.pop();
    }
    public void dfs(int idx, String exp, String num) {
        if(idx == len) {
            if(caculate(exp) == S) {
                ans.add(exp);
            }
            return;
        }
        for(int i = idx; i < len; i++) {
            String tmp = num.substring(idx, i + 1);
            if (tmp.length() > 1 && tmp.charAt(0) == '0') {
                break;
            }
            if (exp.length() > 0) {
                dfs(i + 1, exp + "+" + tmp, num);
                dfs(i + 1,  exp + "-" + tmp, num);
                // (3) * 4 * 5
                //

                dfs(i + 1, exp + "*" + tmp, num);
            } else {
                dfs(i + 1, tmp, num);
            }
        }
    }
    public List<String> addOperators2(String num, int target) {
        ans = new ArrayList<>();
        len = num.length();
        if(len == 0) {
            return ans;
        }
        S = target;
        dfs(0,  new StringBuilder(), num);
        return ans;
    }
    public void dfs(int idx, StringBuilder exp, String num) {
        int n = num.length();
        int len = exp.length();
        if(idx == n) {
            if(caculate(exp.toString()) == S) {
                ans.add(exp.toString());
            }
            return;
        }
        for(int i = idx; i < n; i++) {
            String tmp = num.substring(idx, i + 1);
            if (tmp.length() > 1 && tmp.charAt(0) == '0') {
                break;
            }
            if (exp.length() > 0) {
                exp.append("+").append(tmp);
                dfs(i + 1, exp, num);
                exp.setLength(len);
                exp.append("-").append(tmp);
                dfs(i + 1, exp, num);
                exp.setLength(len);
                exp.append("*").append(tmp);
                dfs(i + 1, exp, num);
                exp.setLength(len);
            } else {
                exp.append(tmp);
                dfs(i + 1, exp, num);
                exp.setLength(len);
            }
        }
    }
    public static void main(String[] args) {
    }
}
