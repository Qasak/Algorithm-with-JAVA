package leetcode.template.Design;

import java.util.HashMap;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/25 14:57
 * (淘汰)最不经常使用LFU
 * 删除策略是「先看访问频次，再看访问时间」
 * 1.「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
 * 2.两个或更多个键具有相同使用频率时，应该去除 最久未使用 的键。
 * 缺点：
 * 在短期的时间内，对某些缓存的访问频次很高，这些缓存会立刻晋升为热点数据，而保证不会淘汰，
 * 这样会驻留在系统内存里面。而实际上，这部分数据只是短暂的高频率访问，之后将会长期不访问,
 * 瞬时的高频访问将会造成这部分数据的引用频率加快，而一些新加入的缓存很容易被快速删除，因为它们的引用频率很低。
 */
class Q460_LFU {
    //    访问次数表: 每个访问次数下对应一个双向链表，表头是最近访问，表尾最久未用(LRU)
    //    1  2  3  4  5  6
    //   a1 b1 c1 d1 e1 f1
    //   a2 b2 c2 d2
    //      b3
    //      b4
    //      b5


    class Node{
        Node(){}
        int key;
        int val;
        int freq;
        Node prev;
        Node next;
        Node(int k, int v) {
            key = k;
            val = v;
            freq = 0;
        }
    }
    int capacity;
    int minFreq = 1;
    // mapIdx 通过频次确定链表的首尾节点
    // 0: head
    // 1: tail
    HashMap<Integer, Node[]> mapIdx;
    // key to node
    HashMap<Integer, Node> mapKn;
    HashMap<Integer, Integer> cnt;
    public Q460_LFU(int cap) {
        capacity = cap;
        mapIdx = new HashMap<>();
        mapKn = new HashMap<>();
        cnt = new HashMap<>();
    }

    public int get(int key) {
        // 存在：将节点移动到freq+1的链表。如果该freq == minfreq且移动后为空，minfreq++
        // if list == null && list is minfreq list , minfreq++
        if(mapKn.containsKey(key)) {
            Node n = mapKn.get(key);
            cnt.put(n.freq, cnt.get(n.freq) - 1);
            if(cnt.get(n.freq) - 1 == 0 && n.freq == minFreq) {
                minFreq++;
            }
            n.freq++;
            moveToHead(mapIdx.get(n.freq)[0], n);
            return n.val;
        } else {
            return -1;
        }
    }
    private void moveToHead(Node head, Node n) {
        Node t = head.next;
        n.next = t;
        n.prev = head;
        t.prev = n;
        head.next = n;
    }
    private void remove(Node n) {
        n.next.prev = n.prev;
        n.prev.next = n.next;
    }
    // size满
    //    1  2  3  4  5  6
    //         c1 d1 e1 f1
    //         c2 d2
    //         c3
    //         c4
    //         c5
    public void put(int key, int value) {
        // 如果key本来存在：次数+1，返回mapKn, mapIdx中移动到freq+1的列，若不存在该频次，创建新的列
        if(mapKn.containsKey(key)) {
            Node n = mapKn.get(key);
            n.freq++;
            mapKn.put(key, n);
            // getHead / getTail
            if(mapIdx.containsKey(n.freq)) {
                Node head = mapIdx.get(n.freq)[0];
                moveToHead(head, n);
            } else {
                mapIdx.put(key, new Node[]{new Node(), new Node()});
            }

        } else {
            // 如果key不存在： 若当前容量已满，移除最小频次列的最后一个元素。若最小频次列空，minfreq+1，
            // 创建新节点 ：一定放入频次1的列
            // remove
            if(capacity == mapKn.size()) {
                // remove min
                Node n = mapIdx.get(key)[minFreq];
                cnt.put(minFreq, cnt.get(minFreq) - 1);
                if(cnt.get(minFreq) == 0) {
                    minFreq++;
                }
                remove(n);

            }
            // head - t
            // head - n - t
            if(mapIdx.containsKey(1)) {
                Node head = mapIdx.get(1)[0];
                Node n = new Node(key, value);
                moveToHead(head, n);
                cnt.put(1, cnt.get(1) + 1);
            } else {
                mapIdx.put(1, new Node[]{new Node(), new Node()});
                Node head = mapIdx.get(1)[0];
                Node n = new Node(key, value);
                moveToHead(head, n);
                cnt.put(1, cnt.get(1) + 1);
            }



        }
    }
}

