package NewCoder.Zuo;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/5/27 11:21
 */
public class CD128_公式字符串求值 {
    // 中缀转后缀 后缀再直接求值
    // 调度场算法 -> 逆波兰表达式求值
    // 整数，加减乘除和左右括号


    // (1-20-7+4+18-4+10-9-11-2+11*20-2/7+17+19+8-13*8/3+(8+13*16)+((11+10-13)+4-11+13-9+15+5*1+11-10-11-(4+10)-17+12+20+(6+20-10))+5+13+20+15-9+18*2-1-19-16/3-8/20-19-3-8+8-17*11-(10+1)-11+1+13/17+(10+13-1*2/7)/12-9-3+2+11+16-15-4-7-16+1+9+((14+12*20/17-9-20-16+4)+4-12)-4/2-3*14+11+(7+10+4+13+16-15)-17/19-1+15+12+13+15+10+19+6+11+8*(20+13)+16+7-10+5+14+14+8-13-(11+(14-14*10+3+(5-7)-5/20-1+16)/(1-14-13*14+6+2+5+14+15+20+17)-(18-(17-18*4+10-(3-16-(9-15))+12)-4)-9-(11+(13+1)+20)*17+(17+6*8+16+6)+5))
    public static void main(String[] args) {
        Map<Character, Integer> priority = new HashMap<>();
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] cs = s.toCharArray();
        int n = cs.length;
        Deque<Character> stk = new LinkedList<>();
        // 1. 数字直接输出
        // 2. 左括号直接入栈
        // 3. 右括号/优先级低于栈顶的符号：栈顶符号依次出栈，再将符号入栈

        // 3 * 1 / 5 + 4
        // 3, 1, 5, /, *, 4, +
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < n) {
            if(Character.isDigit(cs[i])) {
                int num = 0;
                while(i < n &&  Character.isDigit(cs[i])) {
                    num *= 10;
                    num += cs[i] - '0';
                    i++;
                }
                result.add(String.valueOf(num));
            } else if(cs[i] == '(') {
                stk.push(cs[i++]);
            } else {
                if(cs[i] == ')') {
                    while(!stk.isEmpty() && stk.peek() != '(') {
                        result.add(String.valueOf(stk.pop()));
                    }
                    // pop 左括号
                    stk.pop();

                    // 运算符号
                } else {
                    while(!stk.isEmpty() && stk.peek() != '(' && priority.get(cs[i]) <= priority.get(stk.peek())) {

                        result.add(String.valueOf(stk.pop()));
                    }
                    stk.push(cs[i]);
                }
                i++;
            }
        }
        while(!stk.isEmpty()) {
            result.add(String.valueOf(stk.pop()));
        }
        System.out.println(postFix(result));

    }
    public static int postFix(List<String> result) {
        Deque<Integer> stk = new LinkedList<>();
        int i = 0, n = result.size();
        while(i < n) {
            // 数字入栈
            if(result.get(i).length() > 1 ||
                    Character.isDigit(result.get(i).charAt(0))) {
                stk.push(Integer.valueOf(result.get(i)));
            } else {
                // 注意 单独处理一下 -34+7这种输入 它会导致数字栈报空
                int a = stk.pop();
                if(stk.isEmpty()) {
                    stk.push(Integer.valueOf("-" + a));
                } else {
                    int b = stk.pop();
                    switch(result.get(i)) {
                        case "+" :
                            stk.push(b + a);
                            break;
                        case "-" :
                            stk.push(b - a);
                            break;
                        case "*" :
                            stk.push(b * a);
                            break;
                        case "/" :
                            stk.push(b / a);
                            break;

                        default:
                            break;
                    }
                }

            }
            i++;
        }
        return stk.pop();
    }
}
