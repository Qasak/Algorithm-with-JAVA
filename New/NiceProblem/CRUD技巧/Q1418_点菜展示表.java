package leetcode.contest.NiceProblem.CRUD技巧;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/6 11:19
 */
public class Q1418_点菜展示表 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> ans = new ArrayList<>();
        // "food" : {id: num}
        TreeMap<String, Map<Integer, Integer>> map = new TreeMap<>();
        TreeSet<Integer> ids = new TreeSet<>();
        for(List<String> order : orders) {
            int id = Integer.parseInt(order.get(1));
            ids.add(id);
            String food = order.get(2);
            map.putIfAbsent(food, new HashMap<>());
            // id: num
            Map<Integer, Integer> map1 = map.get(food);
            map1.put(id, map1.getOrDefault(id, 0) + 1);
        }
        ans.add(new ArrayList<>());
        ans.get(0).add("Table");
        for(String food: map.keySet()) {
            ans.get(0).add(food);
        }
        for(int id : ids) {
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(id));
            ans.add(list);
        }
        for(int i = 1; i < ans.size(); i++) {
            int id = Integer.parseInt(ans.get(i).get(0));
            for(String food : map.keySet()) {
                // id: num
                Map<Integer, Integer> map1 = map.get(food);
                ans.get(i).add(String.valueOf(map1.getOrDefault(id, 0)));
            }
        }
        return ans;
    }
}
