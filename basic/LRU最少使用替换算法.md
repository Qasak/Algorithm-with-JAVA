## 内置数据结构

Python: OrderedDict

```python
import collections
class LRUCache(collections.OrderedDict):
    def __init__(self, capacity:int):
        super().__init__()
        self.capacity=capacity
    def get(self, key:int) -> int:
        if key not in self:
            return -1
        else:
            self.move_to_end(key)
            return self[key]
    def set(self, key:int, val:int):
        if key in self:
            self.move_to_end(key)
        self[key]=val
        if len(self) > self.capacity:
            self.popitem(last=False)
```

Java: LinkedHashMap

## 双向链表+哈希表

+ 双向链表按被使用顺序存储了键值对，靠头部的键值对是最近使用，尾部是最久未使用。
+ 哈希表即普通的哈希映射(HashMap), 通过缓存数据的键映射到其在双向链表中的位置

首先使用哈希表定位，找出缓存在双向链表的位置，然后将其移动到双向链表头部

> tips: 双向链表实现中，使用一个伪头部(dummy head), 伪尾部(dummy tail)标记界限

```c++
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
            else {
                cache[key]->prev->post=cache[key]->post;
                cache[key]->post->prev=cache[key]->prev;
                mov_to_tail(cache[key]);
                return cache[key]->val;
            }
        }
        
        void put(int key, int value) {
            if(cache[key]) {
                cache[key]->prev->post=cache[key]->post;
                cache[key]->post->prev=cache[key]->prev;
                mov_to_tail(cache[key]);
                cache[key]->val=value;
            } else {
                DLinkNode* t= new DLinkNode(key, value);
                cache[key]=t;
                mov_to_tail(t);
            }
            if(cache.size()>capacity) {
                int f_key = delete_first();
                cache.erase(f_key);
            }
        }

        void mov_to_tail(DLinkNode *node) {
            node->post=tail;
            node->prev=tail->prev;
            tail->prev->post=node;
            tail->prev=node;
        }
        int delete_first() {

            DLinkNode* f=head->post;
            int f_key=f->key;
            f->post->prev=head;
            head->post=f->post;
            delete(f);
            return f_key;
        }
};
```

