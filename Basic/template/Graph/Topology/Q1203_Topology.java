package leetcode.template.Graph.Topology;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/12 8:52
 */
public class Q1203_Topology {
    // 拓扑排序并绑定组
    List<List<Integer>> g;
    int[] ans;
    int[] vis;
    int[] in;
    int idx;
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> bf) {
        g = new ArrayList<>();
        vis = new int[n];
        ans = new int[n];
        in = new int[n];
        idx = n - 1;
        for(int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        // 建有向图
        for(int i = 0; i < n; i++) {
            List<Integer> list = bf.get(i);
            if(list != null) {
                for(int j = 0; j < list.size(); j++) {
                    g.get(list.get(j)).add(i);
                    in[i]++;
                }
            }
        }

        // for(int j = -1; j < m; j++) {
        //     for(int i = 0; i < n; i++) {
        //         if(in[i] == 0 && group[i] == j && vis[i] == 0 && !dfs(i)) {
        //             return new int[]{};
        //         }
        //     }
        // }


        g.sort((a, b) -> group[g.indexOf(a)] - group[g.indexOf(b)]);

        for(int i = 0; i < n; i++) {
            if(vis[i] == 0 && !dfs(i)) {
                return new int[]{};
            }
        }

        return ans;
    }
    boolean dfs(int u) {
        vis[u] = 1;
        for(int v : g.get(u)){
            if(vis[v] == 1) {
                return false;
            } else if(vis[v] == 0 && !dfs(v)) {
                return false;
            }
        }
        vis[u] = 2;
        ans[idx--] = u;
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
//        int[] val = {1, 1, 3, 2, 2, 3, 2, 1};
        int[] val = {1, 1, 3, 2, 2, 3, 2, 1};

        ArrayList <Integer> al = new ArrayList <Integer> () ;
        for(int i = 0 ; i < arr.length ; i++) {
            al.add(arr[i]);
        }
        Collections.sort(al , (left , right) -> val[al.indexOf(left)]  - val[al.indexOf(right)]);
        System.out.println(al);
//        int[] sortedArr = IntStream.range(0, arr.length)
//                .mapToObj(i -> new int[] {arr[i], val[i]})
//                .sorted((lhs, rhs) -> Integer.compare(lhs[1], rhs[1]))
//                .mapToInt(pair -> pair[0])
//                .toArray();
//        System.out.println(Arrays.toString(sortedArr));
    }
}
