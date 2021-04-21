package leetcode.template.Design;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/13 10:50
 */
public class Q705_设计哈希集合 {
    class MyHashSet {
        LinkedList[] entry;
        int l;
        /** Initialize your data structure here. */
        public MyHashSet() {
            l = 769;
            entry = new LinkedList[l];
        }
        public int _hash(int key) {
            return key % l;
        }
        public void add(int key) {
            int h = _hash(key);
            if(entry[h] == null) {
                entry[h] = new LinkedList<>();
            }
            if(entry[h].contains(key)) {
                return;
            }
            entry[h].add(key);
        }

        public void remove(int key) {
            int h = _hash(key);
            if(entry[h] == null) {
                return;
            }
            int idx = entry[h].indexOf(key);
            if(idx == -1) {
                return;
            }
            entry[h].remove(idx);
        }


        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int h = _hash(key);
            if(entry[h] == null) {
                return false;
            }
            return entry[h].contains(key);
        }
    }
    public static void main(String[] args) {
        double a = 1e-5;
        System.out.println((a + 1));
        PriorityQueue<int[]> pq = new PriorityQueue(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int[] a = (int[]) o1;
                int[] b = (int[]) o2;
                if(a[0] == b[0] && a[1] == b[1]) {
                    return 0;
                }
                if((double) ((a[0] + 1) / (a[1] + 1)) < (double) ((b[0] + 1) / (b[1] + 1))) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        double[] ans = new double[]{1,2};
        System.out.println(ans[0]);
    }
}
