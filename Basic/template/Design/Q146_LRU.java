package leetcode.template.Design;

import java.util.HashMap;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/25 14:58
 *
 *  (淘汰)LRU (最近最少使用) 缓存机制
 */
class Q146_LRU {
    private int capacity;
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        Node(int k, int v) {
            key = k;
            val = v;
        }
        Node(){}
    }
    Node head, tail;
    HashMap<Integer, Node> map;
    public Q146_LRU(int c) {
        this.capacity = c;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    // remove Node
    // a <-> n <-> b
    private void remove(Node n) {
        n.next.prev = n.prev;
        n.prev.next = n.next;
    }
    // move to head
    // head <->  t
    // head <-> n <-> t
    private void moveTohead(Node n) {
        Node t = head.next;
        n.prev = head;
        n.next = t;
        head.next = n;
        t.prev = n;
    }
    public int get(int key) {
        if(map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            moveTohead(n);
            return n.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node n;
        if(map.containsKey(key)) {
            n = map.get(key);
            n.val = value;
            remove(n);
        } else {
            if(map.size() == capacity) {
                Node last = tail.prev;
                remove(last);
                // remove k-v
                map.remove(last.key);
            }
            n = new Node(key, value);
            map.put(key, n);
        }
        moveTohead(n);
    }
}