package leetcode.template.Simulation;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/26 12:26
 */
public class Q1128_NumEquivDomino {
    // 1.set+map
    public int numEquivDominoPairs(int[][] arr) {
        Map<Set<Integer>, Integer> map = new HashMap<>();
        for(int[] a : arr) {
            Set<Integer> set = new HashSet<Integer>();
            set.add(a[0]);
            set.add(a[1]);
            map.put(set, map.getOrDefault(set, 0) + 1);
        }
        int ans = 0;
        for(Set<Integer> s : map.keySet()) {
            ans += (map.get(s) * (map.get(s) - 1)) / 2;
        }
        return ans;
    }

    class Pair {
        int x; int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // 用来判等(处理冲突)
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return (x == pair.x && y == pair.y) || (x == pair.y && y == pair.x);
        }
        // 用来定位
        @Override
        public int hashCode() {
            return Objects.hash(x, y) + Objects.hash(y, x);
        }
    }
    public int numEquivDominoPairs1(int[][] arr) {
        Map<Pair, Integer> map = new HashMap<>();
        for(int[] a : arr) {
            Pair p = new Pair(a[0], a[1]);
            // 先定位 再判等
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        int ans = 0;
        for(Pair p : map.keySet()) {
            ans += (map.get(p) * (map.get(p) - 1)) / 2;
        }
        return ans;
    }
    // 2.凑成一个两位数
    public int numEquivDominoPairs2(int[][] arr) {
        int[] map = new int[100];
        for(int[] a : arr) {
            int x = a[0]; int y = a[1];
            int k = x > y ? x * 10 + y : x + y * 10;
            map[k]++;
        }
        int ans = 0;
        for(int i: map) {
            ans += i * (i - 1) / 2;
        }
        return ans;
    }
    public static void main(String[] args) {
        int x = 1; int y = 2;
        System.out.println(Objects.hash(x, y) + Objects.hash(y, x));
    }
}
