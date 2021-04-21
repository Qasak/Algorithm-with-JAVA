package leetcode.template.Graph.Topology;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/12 14:24
 */
public class Q444_ReconstructinoSeq {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if(org == null || org.length == 0 || seqs == null || seqs.size() == 0) {
            return false;
        }
        int n = org.length;
        int[] in = new int[n + 1];
        List<Integer>[] g = new List[n + 1];
        Set<Integer> set = new HashSet<>();
        for(int i = 1 ; i <= n; i++) {
            g[i] = new ArrayList<>();
            set.add(org[i - 1]);
        }
        for(List<Integer> list : seqs) {
            for(int i: list) {
                if(!set.contains(i)) {
                    return false;
                }
            }
        }
        for(List<Integer> list : seqs) {
            for(int i = 1; i < list.size(); i++) {
                in[list.get(i)]++;
                g[list.get(i - 1)].add(list.get(i));

            }
            // in[list.get(1)]++;
            // g[list.get(0)].add(list.get(1));
        }
        Deque<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            if(in[i] == 0) {
                // System.out.println(i);
                q.offer(i);
            }
        }
        if(q.isEmpty() || q.size() > 1) {
            return false;
        }
        // boolean[] vis = new boolean[n + 1];
        int[] ans = new int[n];
        int idx = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            if(size > 1) {
                return false;
            }
            int u = q.poll();
            // vis[u] = true;
            ans[idx++] = u;
            for(int v : g[u]) {
                in[v]--;
                if(in[v] == 0) {
                    q.offer(v);
                }
            }
        }
        for(int i = 0 ; i < n; i++) {
            if(ans[i] != org[i]) {
                return false;
            }
        }
        return true;
    }
}
