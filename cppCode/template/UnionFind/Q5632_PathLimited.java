package leetcode.template.UnionFind;

import leetcode.easy.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/20 17:06
 *
 *
 */

public class Q5632_PathLimited {
    // 给你一个 n个点组成的无向图边集edgeList，
    // 其中edgeList[i] = [ui, vi, disi]表示点ui 和点vi之间有一条长度为disi的边。请注意，两个点之间可能有 超过一条边。
    // queries[j] = [pj, qj, limitj]，你的任务是对于每个查询queries[j]，
    // 判断是否存在从pj到qj的路径，且这条路径上的[每一条]边都 < limitj。


    //1.先将queries 和 edgeList 分别按照边权长度排序。
    //2.处理每一个询问(ai, bi, li)的时候，把edgeList中所有边权<li的点加入并查集。再看ai和bi是否在一个连通块中。


    //     // 输入：n = 3, edgeList = [[0,1,2],[1,2,4],[2,0,8],[1,0,16]], queries = [[0,1,2],[0,2,5]]
    //    // -> [false,true]
    // [0,1,2] < 2: [] -> false
    //[0,2,5] < 5: [0,1,2] [1,2,4] find(a) = find(b)


    // uf[x] : x的父节点
    int[] uf;
    private int find(int x) {
        if(x == uf[x]) {
            return x;
        }
        return uf[x] = find(uf[x]);
    }
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        uf[px] = py;
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        // int j = 0
        // for q in qs:
        //      for j < es.length; j++:
        //          if e.w < q.w :
        //              uf.union(e.a, e.b)
        //      ans.add(uf.find(q.a) == uf.find(q.b)
        uf = new int[n];
        for(int i = 0; i < n; i++) {
            uf[i] = i;
        }
        boolean[] ans = new boolean[queries.length];
        int[][] qs = new int[queries.length][4];
        for(int i = 0; i < queries.length; i++) {
            qs[i][0] = queries[i][0];
            qs[i][1] = queries[i][1];
            qs[i][2] = queries[i][2];
            qs[i][3] = i;
        }

        // h:
        // 0, 1, 2
        // queries:
        // [[0,4,3],[1,4,5],[1,3,1]]
        // sort(h):
        // 2, 0, 1
        // Integer[] h = new Integer[queries.length];
        // for(int i = 0; i < h.length; i++) {
        //     h[i] = i;
        // }
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        Arrays.sort(qs, (a, b) -> a[2] - b[2]);
        // Arrays.sort(h, (a, b) -> queries[a][2] - queries[b][2]);
        // 小于当前limit的边已经加入并查集了，j不用重新置为零
        int j = 0;
        for (int i = 0; i < qs.length; i++) {
//            for(; j < edgeList.length && edgeList[j][2] < q[2]; j++) {
//                union(edgeList[j][0], edgeList[j][1]);
//            }

            // w:
            // q[i][2]: 5,8
            // e[j][2]: 1,3,5,6,8
            for(; j < edgeList.length; j++) {
                if(edgeList[j][2] < qs[i][2]) {
                    union(edgeList[j][0], edgeList[j][1]);
                } else {
                    break;
                }
            }
            ans[qs[i][3]] = find(qs[i][0]) == find(qs[i][1]);
        }
        return ans;
    }
}
