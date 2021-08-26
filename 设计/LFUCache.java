package leetcode.template.Design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/25 18:23
 */
class LFUCache {
    int cap;
    int size;
    // cnt : LRUCache
    TreeMap<Integer, LRUCache> tmap;
    // key: cnt
    Map<Integer, Integer> map;
    public LFUCache(int capacity) {
        cap = capacity;
        size = 0;
        map = new HashMap<>();
        tmap = new TreeMap<>();
    }
    public int get(int key) {
        // System.out.println(map.get(key));

        if(map.containsKey(key)) {

            return upd(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cap == 0) {
            return;
        }
        // 存在
        if(map.containsKey(key)) {
            upd(key, value);
            return;
        }
        // 不存在
        // 空间满了
        if(size == cap) {
            // System.out.println(key);
            // System.out.println(tmap);

            // remove
            dropNode();
            size--;
        }
        Node n = new Node(key, value) ;
        tmap.putIfAbsent(1, new LRUCache(100000));
        LRUCache lru = tmap.get(1);
        lru.put(key, value);
        map.put(key, 1);
        size++;
        // System.out.println(map);

    }
    public void dropNode() {
        LRUCache lru = tmap.firstEntry().getValue();
        // System.out.println(tmap);

        for(Map.Entry<Integer, LRUCache> e : tmap.entrySet()) {
            // System.out.println(e.getKey());

            if(e.getValue().map.size() != 0) {
                lru = e.getValue();
                break;
            }
        }
        Node n = lru.tail.prev;
        map.remove(n.k);
        lru.remove(n);
        lru.map.remove(n.k);
        // System.out.println(n.k);
    }
    // 返回val
    public int upd(int key) {
        int cnt = map.get(key);
        LRUCache lru = tmap.getOrDefault(cnt, new LRUCache(10000));
        Node n = lru.map.get(key);

        // System.out.println(key);
        // System.out.println(n.k);


        int ret = n.v;
        // cnt++
        lru.remove(n);
        lru.map.remove(key);
        tmap.putIfAbsent(++cnt, new LRUCache(10000));
        tmap.get(cnt).put(key, n.v);
        map.put(key, cnt);

        return ret;
    }
    public int upd(int key, int val) {
        int cnt = map.get(key);

        LRUCache lru = tmap.get(cnt);
        Node n = lru.map.get(key);
        // 修改
        n.v = val;
        int ret = n.v;
        // cnt++
        lru.remove(n);
        lru.map.remove(key);
        tmap.putIfAbsent(++cnt, new LRUCache(10000));
        tmap.get(cnt).put(key, n.v);
        map.put(key, cnt);
        return ret;
    }




    // Node
    public class Node {
        int k;
        int v;
        Node prev;
        Node next;
        public Node(int key, int val) {
            k = key; v = val;
        }
        public Node() {
        }
    }
    // LRU
    class LRUCache {
        Node head;
        Node tail;
        int cap;
        public Map<Integer, Node> map;
        // 头 常用
        // 尾 不常用
        public LRUCache(int capacity) {
            cap = capacity;
            map = new HashMap<>();
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }
        public int get(int  key) {
            if(map.containsKey(key)) {
                Node n = map.get(key);
                remove(n);
                moveToHead(n);
                return n.v;
            } else {
                return -1;
            }
        }
        public void put(int key , int value) {
            // 存在
            if(map.containsKey(key)) {
                Node n = map.get(key);
                n.v = value;
                remove(n);
                moveToHead(n);
                return;
            }
            // 不存在, 需要新加入
            if(map.size() == cap) {
                // removeTail
                // c -- n -- tail
                Node n = tail.prev;
                removeTail();
                map.remove(n.k);
            }
            Node n = new Node(key, value);
            moveToHead(n);
            map.put(key, n);
            // move to head
        }
        // head -- c
        public void moveToHead(Node n) {
            Node c = head.next;
            head.next = n;
            c.prev = n;
            n.next = c;
            n.prev = head;
        }
        public void removeTail() {
            remove(tail.prev);
        }
        // a -- n -- c
        public void remove(Node n) {
            // System.out.println(n.k);
            Node a = n.prev;
            Node c = n.next;
            a.next = c;
            c.prev = a;
        }
    }
}