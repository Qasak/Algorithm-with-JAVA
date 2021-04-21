package leetcode.template.UnionFind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/19 9:55
 */
public class Q1584_MinConnCost {
    // 1. Kruskal + UF
    // 根据题意，我们得到了一张 n个节点的完全图，任意两点之间的距离均为它们的曼哈顿距离
    // 现在我们需要在这个图中取得一个子图，恰满足子图的任意两点之间有且仅有一条简单路径，且这个子图的所有边的总权值之和尽可能小。
    // 简单路径，如果一条路径上的顶点除了起点和终点可以相同外，其它顶点均不相同，则称此路径为一条简单路径；起点和终点相同的简单路径称为回路（或环）
    // 能够满足任意两点之间有且仅有一条简单路径只有树，且这棵树包含 n 个节点。我们称这棵树为给定的图的生成树，其中总权值最小的生成树，我们称其为最小生成树
    // 该算法的基本思想是从小到大加入边，是一个贪心算法。


    //  1.将图 G={V,E} 中的所有边按照长度由小到大进行排序，等长的边可以按任意顺序。
    //  2.初始化图 G'为 {V,∅}，从前向后扫描排序后的边，如果扫描到的边 e 在 G 中连接了两个相异的连通块,则将它插入 G‘中。
    //  3.最后得到的图 G'就是图 G 的最小生成树。

    class edge {
        int u;
        int v;
        int w;
        public edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    int[] uf;
    int find(int x) {
        if(x == uf[x]) {
            return x;
        }
        return uf[x] = find(uf[x]);
    }
    void union(int x, int y) {
        uf[find(y)] = find(x);
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        uf = new int[n];
        for(int i = 0; i < n; i++) {
            uf[i] = i;
        }
        List<edge> g = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    continue;
                }
                g.add(new edge(i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])));
            }
        }
        g.sort((a, b) -> a.w - b.w);
        int cost = 0;
        int num = 1;
        for(edge e : g) {
            if(find(e.u) != find(e.v)) {
                union(e.u, e.v);
                cost += e.w;
                num++;
            }
            if(num == n) {
                break;
            }
        }
        return cost;
    }
}
