package leetcode.HighFreq;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/24 19:24
 */
public class Q146_LRU缓存机制 {
    class Node {
        int k;
        int v;
        Node prev;
        Node next;
        @Override
        public String toString() {
            return String.format("k: %d v: %d", k, v);
        }
        public Node(int key, int val) {
            k = key;
            v = val;
        }
        public int getKey() {
            return k;
        }
        public int getValue() {
            return v;
        }
        public void setValue(int val) {
            v = val;
        }

    }
    class LRUCache {
        private int cap;
        Node head;
        Node tail;
        Map<Integer, Node> map;
        public LRUCache(int capacity) {
            cap = capacity;
            map = new HashMap<>();

            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if(map.containsKey(key)) {
                // move to head
                Node node = map.get(key);
                dropNode(node);
                moveToHead(node);
                return node.getValue();
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if(map.containsKey(key)) {
                // flush value
                Node node = map.get(key);
                node.setValue(value);
                // move to head
                dropNode(node);
                moveToHead(node);

            } else {
                if(map.size() == cap) {
                    // remove tail
                    removeTail();
                }
                // add node
                // move to head
                Node node = new Node(key, value);
                map.put(key, node);
                moveToHead(node);
            }
        }
        public void dropNode(Node node) {
            // a node b
            Node a = node.prev;
            Node b = node.next;

            a.next = b;
            b.prev = a;
        }
        public void moveToHead(Node node) {

            // head c
            // head node c
            Node c = head.next;
            node.prev = head;
            node.next = c;
            head.next = node;
            c.prev = node;
        }
        public void removeTail() {
            // d e tail
            Node d = tail.prev.prev;
            Node e = tail.prev;
            d.next = tail;
            tail.prev = d;
            // remove from map
            map.remove(e.getKey());
            System.out.println(e.getKey() + " " + map);
        }
    }
}
