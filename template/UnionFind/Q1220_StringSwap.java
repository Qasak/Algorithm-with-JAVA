package leetcode.template.UnionFind;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/11 9:57
 */
public class Q1220_StringSwap {
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
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        if(n == 0) {
            return s;
        }
        uf = new int[n];
        for(int i = 0; i < n; i++) {
            uf[i] = i;
        }
        char[] ans = new char[n];
        for(List<Integer> list : pairs) {
            union(list.get(0), list.get(1));
        }
        // key : 父节点，value:所有子节点原来的位置
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int p = find(i);
            if(!map.containsKey(p)) {
                map.put(p, new ArrayList<>());
            }
            map.get(p).add(i);
        }
        for(int p : map.keySet()) {
            List<Integer> list = map.get(p);
//            list.sort((a, b) -> s.charAt(a) - s.charAt(b));
            PriorityQueue<Character> pq = new PriorityQueue<>();
            for(int i: list) {
                pq.add(s.charAt(i));
            }
            for(int i: list) {
                ans[i] = pq.poll();
            }
        }
        return String.valueOf(ans);
    }
    public String smallestStringWithSwaps1(String s, List<List<Integer>> pairs) {
        /*
        "cegfxvulsxakw"
        [[6,6],[5,7],[11,4],[0,0],[6,2],[6,7],[0,7],[4,0],[3,1],[2,9],[4,7],[8,6],[9,0]]


        [c, g, k, l, s, u, v, x, x]
        cgklsuvxx
        [e, f]
        cefgklsuvxx
        [a]
        cefgklsuvxax
        [w]
        cefgklsuvxaxw
        "cegfklsuvxaxw"
        "cegfklsuvxaxw"
        */
        //
        StringBuilder ans = new StringBuilder();
        int n = s.length();
        uf = new int[n];
        for(int i = 0; i < n; i++) {
            uf[i] = i;
        }
        for(List<Integer> p: pairs) {
            union(p.get(0), p.get(1));
        }
        char[] cs = s.toCharArray();
        Map<Integer, List<Character>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int p = find(i);
            if(!map.containsKey(p)) {
                map.put(p, new ArrayList<>());
            }
            map.get(p).add(cs[i]);
        }

        for (Map.Entry<Integer, List<Character>> entry : map.entrySet()) {
            entry.getValue().sort((a, b) -> b - a);
        }

        for(int i = 0; i < n; i++) {
            int p = find(i);
            List<Character> list = map.get(p);
            ans.append(list.remove(list.size() - 1));
        }
        return ans.toString();
    }
}
