package leetcode.template.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/10 10:41
 */
public class Q241_为运算表达式设计优先级 {

    public List<Integer> diffWaysToCompute(String input) {
        // [2] , [-17, -5] -> [-34, -10]
        List<Integer> ans = new ArrayList<>();
        char[] cs = input.toCharArray();
        int n = cs.length;
        for(int i = 0; i < n; i++) {
            if(cs[i] == '+' || cs[i] == '-' || cs[i] == '*') {
                List<Integer> l = diffWaysToCompute(input.substring(0, i));
                List<Integer> r = diffWaysToCompute(input.substring(i + 1, n));
                for(int a : l) {
                    for(int b : r) {
                        if(cs[i] == '+') {
                            ans.add(a + b);
                        } else if(cs[i] == '-') {
                            ans.add(a - b);
                        } else {
                            ans.add(a * b);
                        }
                    }
                }
            }
        }
        if(ans.size() == 0) {
            ans.add(Integer.valueOf(input));
        }
        return ans;
    }
    public static void main(String[] args) {
        int 我 = 1;
        System.out.println(我);


    }
}
