/*
LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 
**/

// 双向链表节点：包含key, value值以及前一个和后一个节点
// 
public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}


class DNode {
    DNode prev;
    DNode next;
    int key, value;
    DNode() {
        key = 0;
        value = 0;
        prev = null;
        next = null;
    }
    DNode(int k, int v) {
        key = k;
        value = v;
        prev = null;
        next = null;
    }
}

class LRUCache {

    private int capacity;
    // 哈希表保存key和节点，通过key来定位节点位置
    // 通过哈希表完成O(1)时间内查询key对应的节点
    private final HashMap<Integer, DNode> map;
    private DNode head;
    private DNode tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DNode();
        tail = new DNode();
        head.next = tail;
        tail.prev = head;
    }
    // 如果不存在key，返回-1
    // 如果存在key, 将该节点移到头部，并返回value
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        // 将node从双向链表分离并移动到头部
        DNode node = map.get(key);

        moveToHead(node);
        // 移动完成，返回节点值
        return node.value;
    }

    public void put(int key, int value) {
        // 如果存在，更新值，移到头部
        if(map.containsKey(key)) {
            DNode node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            // 如果不存在，新建节点，将key-Node对加入哈希表，移到头部
            DNode node = new DNode(key, value);
            map.put(key, node);
            addToHead(node);
            // 新增节点后，如果容量超过限制，删除最不常用节点
            if(map.size() > capacity) {
                deleteTail();
            }
        }
    }
    private void removeNode(DNode node) {
        // 改变node前后两个节点的指向
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void addToHead(DNode node) {
        // 先将node自身的两个指针设置好
        node.prev = head;
        node.next = head.next;
        // 设置head的后一个节点的指针
        head.next.prev = node;
        // 设置head的next指针
        head.next = node;
    }
    // 插入到头部
    // 一共改变四个指针：node本身的两个
    // head的下一个
    // head的下一个的前一个
    private void moveToHead(DNode node) {
        removeNode(node);
        addToHead(node);

    }
    // 删除链表尾部最不常用节点
    // tail.prev: 最不常用节点
    private void deleteTail() {
        map.remove(tail.prev.key);
        // 最不常用节点的前一个节点的next = tail
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
    }
}

// c++
struct DLinkNode
{
    DLinkNode* prev;
    DLinkNode* post;
    int key;
    int val;
    DLinkNode(): key(0), val(0), prev(nullptr), post(nullptr) {}
    DLinkNode(int _key, int _val): key(_key), val(_val), prev(nullptr), post(nullptr) {}
};

class LRUCache {
    private:
        
        int capacity;


    public:
        unordered_map<int, DLinkNode*> cache;
        DLinkNode* head;
        DLinkNode* tail;
        LRUCache(int capacity) {
            this->capacity=capacity;
            head = new DLinkNode();
            tail = new DLinkNode();
            head->post=tail;
            tail->prev=head;
        }
        
        int get(int key) {
//            if(!cache[key]) {
//                cache.erase(key);
//                return -1;

//            }
            if(!cache.count(key)) {
				return -1;
			}
			// 将该节点从双向链表分离，并移动到头部
            else {
				// key对应的节点的前一个节点的后一个节点改为当前节点的后一个节点
                cache[key]->prev->post=cache[key]->post;
				// key对应的节点的后一个节点的前一个节点改为当前节点的前一个节点
                cache[key]->post->prev=cache[key]->prev;
				// 这个节点刚使用过，移动到链表尾部(头部)
                mov_to_tail(cache[key]);
				// 返回这个节点的值
                return cache[key]->val;
            }
        }
        
        void put(int key, int value) {
			// 如果哈希表中有该节点，更新值，移到头部
            if(cache[key]) {
                cache[key]->prev->post=cache[key]->post;
                cache[key]->post->prev=cache[key]->prev;
                mov_to_tail(cache[key]);
                cache[key]->val=value;
			// 如果哈希表中没有该节点，创建新节点，移到头部
            } else {
                DLinkNode* t= new DLinkNode(key, value);
                cache[key]=t;
                mov_to_tail(t);
            }
			// 如果跟新后的节点个数大于容量，删除哈希表中最不常用的节点(尾部节点)
            if(cache.size()>capacity) {
                int f_key = delete_first();
                cache.erase(f_key);
            }
        }
		// 辅助函数：移动节点到尾部(头部)
        void mov_to_tail(DLinkNode *node) {
			// 当前节点已从双向链表分离
			// 节点后一个节点= tail
			// 节点前一个节点= tail的前一个
			// tail的前一个的后一个节点=node
			// tail的前一个=node
            node->post=tail;
            node->prev=tail->prev;
            tail->prev->post=node;
            tail->prev=node;
        }
		// 辅助函数：删除双向链表中最不常用的节点(头/尾部)
        int delete_first() {

            DLinkNode* f=head->post;
            int f_key=f->key;
            f->post->prev=head;
            head->post=f->post;
            delete(f);
            return f_key;
        }
};