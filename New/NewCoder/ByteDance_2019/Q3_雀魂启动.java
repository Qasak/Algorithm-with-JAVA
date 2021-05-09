package NewCoder.ByteDance_2019;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/31 12:14
 */
public class Q3_雀魂启动 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] t = line.split(" ");
        int n = t.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i <= 9; i++) {
            map.put(i, 0);
        }
        for(int i = 0; i < n; i++) {
            int j = Integer.parseInt(t[i]);
            map.put(j, map.get(j) + 1);
        }
        List<Integer> ans = dfs(map);
        for(int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i));
            if(i != ans.size() - 1) {
                System.out.print(" ");
            }
        }
    }
    public static List<Integer> dfs(Map<Integer, Integer> map) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= 9; i++) {
            if(map.get(i) == 4) {
                continue;
            }
            map.put(i, map.get(i) + 1);
            if(check(map)) {
                ans.add(i);
            }
            map.put(i, map.get(i) - 1);
        }
        return ans;
    }
    public static boolean check(Map<Integer, Integer> map) {
        // 雀头
        TreeMap<Integer, Integer> map1 = new TreeMap<>(map);
        for(int i : map1.keySet()) {
            if(map1.get(i) >= 2) {
                map1.put(i, map1.get(i) - 2);
                if(check1(map1)) {
                    return true;
                }
                map1.put(i, map1.get(i) + 2);
            }
        }
        return false;
    }
    public static boolean check1(TreeMap<Integer, Integer> map) {
        int sum = 0;
        for(int i : map.keySet()) {
            sum += map.get(i);
        }
        if(sum == 0) {
            return true;
        }
        for(int i : map.keySet()) {
            if(map.get(i) >= 3) {
                map.put(i, map.get(i) - 3);
                if(check1(map)) {
                    return true;
                }
                map.put(i, map.get(i) + 3);
            } else if(map.get(i) >= 1) {
                if(map.getOrDefault(i + 1, 0) > 0 && map.getOrDefault(i + 2, 0) > 0) {
                    for(int j = 0; j < 3; j++) {
                        map.put(i + j, map.get(i + j) - 1);
                    }
                    if(check1(map)) {
                        return true;
                    }
                    for(int j = 0; j < 3; j++) {
                        map.put(i + j, map.get(i + j) + 1);
                    }
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
