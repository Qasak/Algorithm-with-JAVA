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