package leetcode.template.Graph.SpanningTree;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/21 10:55
 */
public class Q1489_CriticalEdges {
    class UF {
        public UF(int n) {
            uf = new int[n];
            for(int i = 0; i < n; i++) {
                uf[i] = i;
            }
            cnt = n;
        }
        int cnt;
        int[] uf;
        int find(int x) {
            if(x == uf[x]) {
                return x;
            }
            return uf[x] = find(uf[x]);
        }
        void union(int x, int y) {
            uf[find(x)] = find(y);
            cnt--;
        }
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        UF uf = new UF(n);
        int k = edges.length;
        Integer[] idx = new Integer[k];
        for(int i = 0; i < k; i++) {
            idx[i] = i;
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        Arrays.sort(idx, (a, b) -> edges[a][2] - edges[b][2]);

        // idx[6] = 3
        // 现在的下标j通过idx[j]映射到原来的下标i
        int val = 0;
        // Kruskal
        for(int i = 0; i < k; i++) {
            if(uf.find(edges[idx[i]][0]) != uf.find(edges[idx[i]][1])) {
                uf.union(edges[idx[i]][0], edges[idx[i]][1]);
                val += edges[idx[i]][2];
            }
        }
        for(int i = 0; i < k; i++) {
            int val1 = 0;
            // i : 不再选择的边
            uf = new UF(n);
            for(int j = 0; j < k; j++) {

                if(idx[i].equals(idx[j])) {
                    continue;
                }

                if(uf.find(edges[idx[j]][0]) != uf.find(edges[idx[j]][1])) {
                    uf.union(edges[idx[j]][0], edges[idx[j]][1]);
                    val1 += edges[idx[j]][2];
                }
            }
            // 是关键边:没有这条边后，不再联通，或联通但权值大于val
            if(uf.cnt != 1 || val1 > val) {
                ans.get(0).add(idx[i]);
                continue;
            }
            // 联通的情况下判断是否是伪关键边：先将其加入集合，再运行Kruskal，若大于val，则其是伪关键边
            // 首先「需要注意的是，关键边也满足伪关键边对应的性质。」， 那么伪关键边**对应的性质**，亦即「如果此边在Kruskal算法执行前预先加入，那么生成的树总权值与最小生成树的权值相等」，是关键边的必要条件。            uf = new UF(n);
            uf.union(edges[idx[i]][0], edges[idx[i]][1]);
            val1 = edges[idx[i]][2];
            for(int j = 0; j < k; j++) {

                if(idx[i].equals(idx[j])) {
                    continue;
                }

                if(uf.find(edges[idx[j]][0]) != uf.find(edges[idx[j]][1])) {
                    uf.union(edges[idx[j]][0], edges[idx[j]][1]);
                    val1 += edges[idx[j]][2];
                }
            }
            if(val1 == val) {
                ans.get(1).add(idx[i]);
            }
        }
        return ans;
    }

/*
5
[[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]

6
[[0,1,1],[1,2,1],[0,2,1],[2,3,4],[3,4,2],[3,5,2],[4,5,2]]

4
[[0,1,1],[0,3,1],[0,2,1],[1,2,1],[1,3,1],[2,3,1]]
*/
}
