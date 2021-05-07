package leetcode.HighFreq;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/25 21:19
 */
class Node<K, V> {
    K k;
    V v;
    Node<K, V> prev;
    Node<K, V> next;
    public Node(K key, V val) {
        k = key;
        v = val;
    }
    public Node() {
    }
    public K getKey() {
        return k;
    }
    public V getValue() {
        return v;
    }
    public void setValue(V val) {
        v = val;
    }

}
class LRUCache<K, V> {
    private final int cap;
    Node<K, V> head;
    Node<K, V> tail;
    Map<K, Node<K, V>> map;
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();

        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        if(map.containsKey(key)) {
            // move to head
            Node<K, V> node = map.get(key);
            dropNode(node);
            moveToHead(node);
            return node.getValue();
        } else {
            return null;
        }
    }

    public void put(K key, V value) {
        if(map.containsKey(key)) {
            // flush value
            Node<K, V> node = map.get(key);
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
            Node<K, V> node = new Node<>(key, value);
            map.put(key, node);
            moveToHead(node);
        }
    }
    public void dropNode(Node<K, V> node) {
        // a node b
        Node<K, V> a = node.prev;
        Node<K, V> b = node.next;

        a.next = b;
        b.prev = a;
    }
    public void moveToHead(Node<K, V> node) {

        // head c
        // head node c
        Node<K, V> c = head.next;
        node.prev = head;
        node.next = c;
        head.next = node;
        c.prev = node;
    }
    public void removeTail() {
        // d e tail
        Node<K, V> d = tail.prev.prev;
        Node<K, V> e = tail.prev;
        d.next = tail;
        tail.prev = d;
        // remove from map
        map.remove(e.getKey());
//        System.out.println(e.getKey() + " " + map);
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> lruCache = new LRUCache<>(2);
        lruCache.put(1, 1); // 缓存是 {1=1}
        lruCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lruCache.get(1));        ;    // 返回 1
        lruCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lruCache.get(2));        ;    // 返回 -1 (未找到)

        lruCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lruCache.get(1));        ;    // 返回 -1 (未找到)
        System.out.println(lruCache.get(3));        ;    // 返回 3
        System.out.println(lruCache.get(4));        ;    // 返回 4
    }
}
