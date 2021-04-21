package leetcode.template.Hash;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/6 11:35
 */
public class Q399_Divide {
    public double[] calcEquation(List<List<String>> eqs, double[] vals, List<List<String>> qrs) {
        // a/b = 2 b/c = 3 a/c = 6
        // ab bc ac

        Set<String> set = new HashSet<>();
        Map<String, Double> map = new ConcurrentHashMap<>();
        int n = eqs.size();
        for(int i = 0; i < n; i++) {
            List<String> eq = eqs.get(i);
            String x = eq.get(0);
            String y = eq.get(1);
            set.add(x + "/" + y);
            set.add(x + "/" + x);
            set.add(y + "/" + y);

            map.put(x + "/" + y, vals[i]);
            map.put(x + "/" + x, 1.0);
            map.put(y + "/" + y, 1.0);
        }

        for(String key1 : map.keySet()) {
            for(String key2: map.keySet()) {
                String[] s1 = key1.split("/");
                String[] s2 = key2.split("/");
                if(s1[1].equals(s2[0])) {
                    map.putIfAbsent(s1[0] + "/" + s2[1], map.get(key1) * map.get(key2));
                }
                // s1 :["x3","x4"]
                // s2 :["x2","x3"]
                // x2 x4
                if(s1[0].equals(s2[1])) {
                    map.putIfAbsent(s2[0] + "/" + s1[1], map.get(key1) * map.get(key2));
                }
                // e / a  e / b -> b / a
                if(s1[0].equals(s2[0])) {
                    map.putIfAbsent(s2[1] + "/" + s1[1], map.get(key1) / map.get(key2));
                }
                // a / e  b / e -> a / b
                if(s1[1].equals(s2[1])) {
                    map.putIfAbsent(s1[0] + "/" + s2[1], map.get(key1) / map.get(key2));
                }
            }
        }
        int m = qrs.size();
        double[] ans = new double[m];
        int idx = 0;
        for(List<String> q : qrs) {
            if(map.containsKey(q.get(0) + "/" + q.get(1))) {
                ans[idx++] = map.get(q.get(0) + "/" + q.get(1));
            } else if(map.containsKey(q.get(1) + "/" + q.get(0))) {
                ans[idx++] = 1.0 / map.get(q.get(1) + "/" + q.get(0));
            } else {
                ans[idx++] = -1;
            }
        }
        return ans;
    }
}
