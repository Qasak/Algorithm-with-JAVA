package leetcode.template.Design;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/13 11:30
 */
public class Q706_设计HashMap {
    class MyHashMap {
        class Node {

            @Override
            public int hashCode() {
                return Objects.hash(k, v);
            }
            @Override
            public boolean equals(Object o) {
                if(this == o) {
                    return true;
                }
                if(o == null || this.getClass() != o.getClass()) {
                    return false;
                }
                Node n = (Node) o;
                return this.k == n.k && this.v == n.v;
            }
            int k;
            int v;
            public Node(int key, int val) {
                k = key;
                v = val;
            }
        }
        LinkedList[] entry;
        int cap;
        /** Initialize your data structure here. */
        public MyHashMap() {
            cap = 796;
            entry = new LinkedList[cap];
        }
        private int hash(int key) {
            return key % cap;
        }
        /** value will always be non-negative. */
        public void put(int key, int value) {
            int h = hash(key);
            if(entry[h] == null) {
                entry[h] = new LinkedList<Node>();
            }
            if(get(key) != -1) {
                for(Object o : entry[h]) {
                    Node n = (Node) o;
                    if(n.k == key) {
                        n.v = value;
                    }
                }
            } else {
                entry[h].add(new Node(key, value));
            }
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int h = hash(key);
            if(entry[h] == null) {
                return -1;
            }
            for(Object o : entry[h]) {
                Node n = (Node) o;
                if(n.k == key) {
                    return n.v;
                }
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int v = get(key);
            if(v == -1) {
                return;
            }
            int h = hash(key);
            for(Object o : entry[h]) {
                Node n = (Node) o;
                if(n.k == key) {
                    entry[h].remove(n);
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1); list.add(3);

    }
}
