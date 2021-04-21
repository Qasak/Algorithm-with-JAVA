package leetcode.template.UnionFind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/10 12:35
 */
public class Q5650_MinHammingDistance {
    int[] uf;
    private int find(int x) {
        if(uf[x] == x) {
            return x;
        }
        return uf[x] = find(uf[x]);
    }
    // 把x的父节点合并到y的父节点
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        uf[px] = py;
    }
    /*
    [5,1,2,4,3]
    [5,5,5,5,5]
    [[0,4],[4,2],[1,3],[1,4]]

    */
    // 有bug


    /*
        [5,1,2,5]
        [5,5,4,2]
        [[0,3],[3,2],[1,3]]
     */
    public int minimumHammingDistance(int[] s, int[] t, int[][] g) {
        int n = s.length;
        uf = new int[n];
        for(int i = 0; i < n; i++) {
            uf[i] = i;
        }
        for(int[] it : g) {
            union(it[0], it[1]);
        }

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int p = find(i);
            if(!map.containsKey(p)) {
                map.put(p, new HashMap<>());
            }
            map.get(p).put(s[i], map.get(p).getOrDefault(s[i], 0) + 1);
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            int p = find(i);
            if(!map.get(p).containsKey(t[i]) || map.get(p).get(t[i]) == 0) {
                ans++;
            } else {
                // C++写法 : map[p][t[i]]--

                // 取内层map2
                Map<Integer, Integer> map2 = map.get(p);
                // 修改map2
                map2.put(t[i], map2.get(t[i]) - 1);
                // 修改map
//                map.put(p, map2);
            }
        }
        return ans;
    }
    // 如果source中有重复元素：错误
    public int minimumHammingDistance1(int[] s, int[] t, int[][] g) {
        int n = s.length;
        uf = new int[100001];
        for(int i = 0; i < 100001; i++) {
            uf[i] = i;
        }
        // 可交换的点合并
        for(int[] k : g) {
            union(s[k[0]], s[k[1]]);
        }

        // 每个联通分量下：每个节点的出现次数
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            // 存在联通分量
            int p = find(s[i]);
            if(map.containsKey(p)) {
                Map<Integer, Integer> tmap = map.get(p);
                // 节点出现次数+1
                tmap.put(s[i], tmap.getOrDefault(s[i], 0) + 1);
            } else {
                Map<Integer, Integer> tmap = new HashMap<>();
                tmap.put(p, 1);
                map.put(p, tmap);
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            // 不在一个联通分量
            if(find(s[i]) != find(t[i])) {
                cnt++;
                // continue;
                // 在一个联通分量内
            } else {
                // 找到联通分量
                int p = find(t[i]);
                // 找到出现次数
                Map<Integer, Integer> tmap = map.get(p);
                if(tmap.get(t[i]) > 0) {
                    tmap.put(t[i], tmap.get(t[i]) - 1);
                } else {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
