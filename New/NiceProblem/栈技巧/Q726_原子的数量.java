package leetcode.contest.NiceProblem.栈技巧;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/5 9:58
 */
public class Q726_原子的数量 {
     // 给不同位置的相同原子编号，最后合并
     public String countOfAtoms(String formula) {
         // 符号 直接入栈
         // 数字 看前面是否是) 是：一直找到( ， 否
         // 原子 记录下原子和id (Mg_0 和 Mg_1不同), 入栈

         // 最后合并(Mg_0 和 Mg_1合并)

         char[] cs = formula.toCharArray();
         int n = cs.length;
         int i = 0;
         Deque<String> stk = new LinkedList<>();
         Map<String, Integer> map = new HashMap<>();
         int id = 0;
         while(i < n) {
             if(cs[i] == '(' || cs[i] == ')') {
                 stk.push(String.valueOf(cs[i++]));
             } else if(Character.isDigit(cs[i])) {
                 int num = 0;
                 while(i < n && Character.isDigit(cs[i])) {
                     num *= 10;
                     num += cs[i] - '0';
                     i++;
                 }
                 if(!stk.isEmpty() && stk.peek().equals(")")) {

                     stk.pop();
                     List<String> list = new ArrayList<>();
                     while(!stk.peek().equals("(")) {
                         String atom = stk.pop();
                         map.put(atom, map.get(atom) * num);
                         list.add(atom);
                     }
                     stk.pop();
                     // 括号展开后放回atom
                     for(int j = list.size() - 1; j >= 0; j--) {
                         stk.push(list.get(j));
                     }
                 } else if(!stk.isEmpty()) {
                     String atom = stk.pop();
                     map.put(atom, map.get(atom) * num);
                     stk.push(atom);
                 }

             } else {
                 // atom
                 StringBuilder sb = new StringBuilder();
                 sb.append(cs[i]);
                 int j = i + 1;
                 while(j < n && Character.isLowerCase(cs[j])) {
                     sb.append(cs[j++]);
                 }
                 sb.append('_').append(id++);
                 map.put(sb.toString(), 1);
                 stk.push(sb.toString());
                 i = j;
             }
         }
         Map<String, Integer> tmap = new TreeMap<>();
         for(String s : map.keySet()) {
             String atom = s.split("_")[0];
             tmap.put(atom, tmap.getOrDefault(atom, 0) + map.get(s));
         }
         StringBuilder ans = new StringBuilder();
         for(String s : tmap.keySet()) {
             ans.append(s);
             if(tmap.get(s) > 1) {
                 ans.append(tmap.get(s));
             }
         }
         return ans.toString();
     }
}
