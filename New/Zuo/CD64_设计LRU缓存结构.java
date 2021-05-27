package NewCoder.Zuo;
import java.util.*;
public class CD64_设计LRU缓存结构 {
}
class Node<K, V> {
    public K k;
    public V v;
    public Node<K, V> prev;
    public Node<K, V> next;
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
    Node<K, V> head = new Node<K, V>();
    Node<K, V> tail = new Node<K, V>();
    Map<K, Node<K, V>> map;
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        head.next = this.tail;
        tail.prev = this.head;
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
}
class MainOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cap = sc.nextInt();
        LRUCache<Integer, Integer> lruCache = new LRUCache<Integer, Integer>(cap);

        for(int i = 0; i < n; i++) {
            int op = sc.nextInt();
            if(op == 1) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                lruCache.put(x, y); // 缓存是 {1=1}
            } else {
                int x = sc.nextInt();
                Integer ret = lruCache.get(x);
                System.out.println(ret == null ? -1 : ret);
            }
        }
    }
}



