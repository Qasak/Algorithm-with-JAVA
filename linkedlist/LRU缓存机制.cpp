/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */

struct DNode {
    DNode *prev, *next;
    int k,v;
    DNode(): prev(nullptr),next(nullptr),k(0),v(0) {}
    DNode(int k, int v): prev(nullptr),next(nullptr),k(k),v(v) {}
};


class LRUCache {
    
private:
    int cap;
    unordered_map<int, DNode*> lru;
    DNode* head, *tail;
public:
    LRUCache(int capacity) {
        cap=capacity;
        head = new DNode();
        tail = new DNode();
        head->next=tail;
        tail->prev=head;
    }
    
    int get(int key) {
        if(!lru.count(key))
            return -1;
        auto &node=lru[key];
        node->next->prev=node->prev;
        node->prev->next=node->next;
        move_to_tail(node);
        return node->v;
    }
    
    void put(int key, int value) {
        if(!lru.count(key)) {
            DNode* t=new DNode(key, value);
            lru[key]=t;
            move_to_tail(t);
        } else {
            auto &node=lru[key];
            node->v=value;
            node->next->prev=node->prev;
            node->prev->next=node->next;
            move_to_tail(node);
        }
        if(lru.size()>cap) {
            int f_key=delete_first();
            lru.erase(f_key);
        }
    }
    
    void move_to_tail(DNode* node) {
        node->next=tail;
        node->prev=tail->prev;
        
        tail->prev->next=node;
        tail->prev=node;
        
    }
    
    int delete_first() {
        DNode* f=head->next;
        int f_key=f->k;
        head->next=head->next->next;
        f->next->prev=head;
        delete(f);
        return f_key;
    }
};

