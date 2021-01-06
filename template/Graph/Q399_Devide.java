package leetcode.template.Graph;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/6 11:37
 */
public class Q399_Devide {
    // HashMap硬做
    public double[] calcEquation(List<List<String>> eqs, double[] vals, List<List<String>> qrs) {
        // a/b = 2 b/c = 3 a/c = 6
        // ab bc ac

        Map<String, Double> map = new ConcurrentHashMap<>();
        int n = eqs.size();
        for(int i = 0; i < n; i++) {
            List<String> eq = eqs.get(i);
            String x = eq.get(0);
            String y = eq.get(1);

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
    // DFS
    double[][] g;
    public double[] calcEquation1(List<List<String>> eqs, double[] vals, List<List<String>> qrs) {
        // a/b:x b/c:y -> a/c:x*y
        // a/b c/b -> a/c:x/y
        // b/a b/c -> c/a:x/y
        //
        //
        Set<String> vert = new HashSet<>();
        for(List<String> list : eqs) {
            vert.add(list.get(0));
            vert.add(list.get(1));
        }
        int n = vert.size();
        Map<String, Integer> map = new HashMap<>();
        int id = 0;
        for(String v: vert) {
            map.put(v, id++);
        }
        g = new double[n][n];
        int idx = 0;
        for(List<String> list : eqs) {
            // vert.add(list.get(0));
            // vert.add(list.get(0));
            int s = map.get(list.get(0)), t = map.get(list.get(1));
            g[s][s] = 1.0;
            g[t][t] = 1.0;
            g[s][t] = vals[idx];
            g[t][s] = 1 / vals[idx];
            idx++;
        }
        int j = 0;
        double[] ret = new double[qrs.size()];
        for(List<String> q : qrs) {
            int s = map.getOrDefault(q.get(0), -1), t = map.getOrDefault(q.get(1), -1);
            if(s == -1 || t == -1) {
                ret[j++] = -1;
                continue;
            }
            boolean[] vis = new boolean[n];
            ret[j++] = dfs(s, t, 1.0, vis);

        }
        return ret;
    }
    private double dfs(int cur, int t, double ans, boolean[] vis) {
        if(vis[cur]) {
            return -1;
        }
        vis[cur] = true;

        if(cur == t) {
            return ans;
        }
        for(int i = 0; i < vis.length; i++) {
            if(g[cur][i] != 0 && !vis[i]) {
                ans *= g[cur][i];
                double d = dfs(i, t, ans, vis);
                if(d != -1) {
                    return d;
                }
                ans /= g[cur][i];
            }
        }
        return -1;
    }
    // UF
    public double[] calcEquation2(List<List<String>> eqs, double[] vals, List<List<String>> qrs) {
        return null;
    }
    // BFS
    public double[] calcEquation3(List<List<String>> eqs, double[] vals, List<List<String>> qrs) {
        // a/b:x b/c:y -> a/c:x*y
        // a/b c/b -> a/c:x/y
        // b/a b/c -> c/a:x/y
        //
        //
        Set<String> vert = new HashSet<>();
        for(List<String> list : eqs) {
            vert.add(list.get(0));
            vert.add(list.get(1));
        }
        int n = vert.size();
        Map<String, Integer> map = new HashMap<>();
        int id = 0;
        for(String v: vert) {
            map.put(v, id++);
        }
        double[][] g = new double[n][n];
        int idx = 0;
        for(List<String> list : eqs) {
            // vert.add(list.get(0));
            // vert.add(list.get(0));
            int s = map.get(list.get(0)), t = map.get(list.get(1));
            g[s][s] = 1.0;
            g[t][t] = 1.0;
            g[s][t] = vals[idx];
            g[t][s] = 1 / vals[idx];
            idx++;
        }
        // BFS
        int j = 0;
        double[] ret = new double[qrs.size()];
        for(List<String> q : qrs) {
            int s = map.getOrDefault(q.get(0), -1), t = map.getOrDefault(q.get(1), -1);
            if(s == -1 || t == -1) {
                ret[j++] = -1;
                continue;
            }
            boolean[] vis = new boolean[n];
            Deque<Integer> dq = new LinkedList<>();
            dq.offer(s);
            vis[s] = true;
            double ans = 1.0;
            while(!dq.isEmpty()) {
                int node = dq.poll();

                // vis[node] = true;
                if(node == t) {
                    ret[j++] = ans;
                    break;
                }
                // b -> a
                // b -> c
                for(int k = 0; k < n; k++) {
                    if(g[node][k] != 0) {
//                        System.out.println(node + " " + k);

                        vis[k] = true;
                        // TODO
                        ans *= g[node][k];
                        dq.offer(k);
                    }
                }
            }
        }
        return ret;
    }
    // Floyd
    // 对于查询数量很多的情形，如果为每次查询都独立搜索一次，则效率会变低。为此，我们不妨对图先做一定的预处理，随后就可以在较短的时间内回答每个查询。
    //
    //在本题中，我们可以使用 Floyd 算法，预先计算出任意两点之间的距离。
    public double[] calcEquation4(List<List<String>> eqs, double[] vals, List<List<String>> qrs) {
        return null;
    }

}
