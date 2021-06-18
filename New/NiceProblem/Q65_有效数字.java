package leetcode.contest.NiceProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/17 10:09
 */
public class Q65_有效数字 {
    public boolean isNumber(String s) {
        // e前后需要有符号
        //
        Set<Character> valid = new HashSet<Character>();
        for(int i = 0; i < 10; i++) {
            valid.add((char)('0' + i));
        }
        valid.add('e'); valid.add('E');
        valid.add('+'); valid.add('-');
        valid.add('.');
        int cntNum = 0;
        int cntE = 1, cntP = 2, cntN = 2, cntDot = 1;
        for(char c : s.toCharArray()) {
            if(!valid.contains(c)) {
                return false;
            }
            if(Character.isDigit(c)) {
                cntNum++;
            }
            if(c == 'e' || c == 'E') {
                cntE--;
            }
            if(c == '+') {
                cntP--;
            }
            if(c == '-') {
                cntN--;
            }
            if(c == '.') {
                cntDot--;
            }
        }
        if(cntNum == 0 || cntP < 0 || cntN < 0 || cntE < 0 || cntDot < 0) {
            return false;
        }
        int n = s.length();
        char[] cs = s.toCharArray();
        cntE = 1; cntP = 1; cntN = 1; cntDot = 1;
        for(int i = 0;i < n; i++) {
            // + / - 前面是e或第一个 3e+7 / 3e-7
            if(cs[i] == '+' || cs[i] == '-') {
                if(i != 0 && (!(cs[i - 1] == 'e' || cs[i - 1] == 'E'))) {
                    return false;
                }
                if(i == n - 1 || !(Character.isDigit(cs[i + 1]) || cs[i + 1] == '.')) {
                    return false;
                }
                if(cs[i] == '+') {
                    cntP--;
                }
                if(cs[i] == '-') {
                    cntN--;
                }
            }
            // e 前面必须是数字, 后面是+ / - / 数字
            if(cs[i] == 'e' || cs[i] == 'E') {
                if(i == 0 || i == n - 1 ||
                        !(Character.isDigit(cs[i - 1]) || cs[i - 1] == '.') ||
                        !(Character.isDigit(cs[i + 1]) || cs[i + 1] != '+' || cs[i + 1] != '-')) {
                    return false;
                }
                cntE--;
            }
            // e 后面不能有小数点
            // 小数点后面必须是数字或e
            if(cs[i] == '.') {
                if(cntE == 0 || (i != n - 1 && !(Character.isDigit(cs[i + 1]) || cs[i + 1] == 'e' || cs[i + 1] == 'E' ))) {
                    return false;
                }
                if(i == 0 && i != n - 1 && !Character.isDigit(cs[i + 1])) {
                    return false;
                }
            }
        }
        return true;
    }

    // 正则
    // ^[+-]?\d*((\d\.|\.\d)|\d)\d*([eE][+-]?\d+)?$
}
