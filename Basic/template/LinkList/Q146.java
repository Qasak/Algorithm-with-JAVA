package leetcode.template.LinkList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/23 19:03
 */
public class Q146 {
    class LRUCache {
        int cap;
        class Node {
            int key;
            int val;
            Node next;
            Node prev;
            public Node() {}
            public Node(int k, int v) {
                this.key = k;
                this.val = v;
                next = null;
                prev = null;
            }

        }
        Node head;
        Node tail;
        Map<Integer, Node> map;
        public LRUCache(int capacity) {
            this.cap = capacity;
            map = new HashMap<>();
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }
        public void moveToHead(Node n) {
            n.next.prev = n.prev;
            n.prev.next = n.next;
            n.next = head.next;
            n.prev = head;
            head.next.prev = n;
            head.next = n;
        }
        public void insertToHead(Node n) {
            n.next = head.next;
            n.prev = head;
            head.next.prev = n;
            head.next = n;
        }
        public int get(int key) {
            if(map.containsKey(key)) {
                Node n = map.get(key);
                moveToHead(n);
                return n.val;
            } else {
                return -1;
            }
        }
        public int deleteTail() {
            Node last = tail.prev;
            int key = last.key;
            last.prev.next = tail;
            tail.prev = last.prev;
            last.prev = null;
            last.next = null;
            return key;
        }
        public void put(int key, int value) {
            if(map.containsKey(key)) {
                Node n = map.get(key);
                n.val = value;
                moveToHead(n);
            } else {
                if(map.size() == this.cap) {
                    map.remove(deleteTail());
                }
                Node n = new Node(key, value);
                insertToHead(n);
                map.put(key, n);
            }
        }
    }
}
