package leetcode.template.Expression;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/23 11:32
 */
public class Q736_LispEvaluate {
    public int evaluate(String s) {
        return evaluate(s, new HashMap<>());
    }
    // (add 1 2)
    private int evaluate(String s, HashMap<String, Integer> map) {
        int p = 0;
        int n = s.length();

        // 分割表达式
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == ' ') {
                p = i;
                break;
            }
        }
        // 只有一个表达式
        if(p == 0) {
            int i = 0;
            for(;i < n && s.charAt(i) != ')'; i++) {

            }
            if(s.charAt(0) == '-' || (s.charAt(0) <= '9' && s.charAt(0) >= '0')) {
                return Integer.parseInt(s.substring(0, i));
            } else {

                return map.get(s);
            }
        }
        String op = s.substring(1, p);
        if("add".equals(op)) {
            int cnt = 0;
            int q = 0;
            for(int i = p + 1; i < n; i++) {
                if(s.charAt(i) == '(') {
                    cnt++;
                }
                if(s.charAt(i) == ')') {
                    cnt--;
                }
                if(s.charAt(i) == ' ' && cnt == 0) {
                    q = i;
                    break;
                }
            }
            String e1 = s.substring(p + 1, q);
            String e2 = s.substring(q + 1, n - 1);
            return evaluate(e1, map) + evaluate(e2, map);
        } else if("mult".equals(op)) {
            int cnt = 0;
            int q = 0;
            for(int i = p + 1; i < n; i++) {
                if(s.charAt(i) == '(') {
                    cnt++;
                }
                if(s.charAt(i) == ')') {
                    cnt--;
                }
                if(s.charAt(i) == ' ' && cnt == 0) {
                    q = i;
                    break;
                }
            }
            String e1 = s.substring(p + 1, q);
            String e2 = s.substring(q + 1, n - 1);
            return evaluate(e1, map) * evaluate(e2, map);
        } else {

            String let = s.substring(p + 1, n - 1);

            ArrayList<String> list = new ArrayList<>();
            int cnt = 0;
            for(int i = 0; i < let.length(); ) {
                if(let.charAt(i) == '(') {
                    cnt++;
                    int j = i + 1;
                    while(cnt != 0) {
                        if(let.charAt(j) == '('){
                            cnt++;
                        }
                        if(let.charAt(j) == ')'){
                            cnt--;
                        }
                        j++;
                    }
                    list.add(let.substring(i, j));
                    i = j + 1;
                } else {
                    int j = i;
                    while(j < let.length() && let.charAt(j) != ' ') {
                        j++;
                    }
                    list.add(let.substring(i, j));
                    i = j + 1;
                }
            }
            HashMap<String, Integer> newMap = new HashMap<>(map);
            for(int i = 0; i < list.size() - 1; i += 2) {
                String k = list.get(i);
                int v = evaluate(list.get(i + 1), newMap);
                newMap.put(k, v);
            }
            return evaluate(list.get(list.size() - 1), newMap);

        }
    }
}
