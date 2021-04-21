class AllOne {
public:
    /** Initialize your data structure here. */
    struct Node{
        unordered_set<string> container;
        int val = 0;
        Node(int v):val(v){}
    };
    unordered_map<string, list<Node>::iterator> kv;
    list<Node> List;
    AllOne() {}
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    void inc(string key) {
        if(kv.count(key)){
            auto oldNode = kv[key];
            auto newNode = next(oldNode, 1);
            if(newNode == List.end() || newNode->val>oldNode->val+1){
                newNode = List.insert(newNode, Node(oldNode->val+1));
            }

            newNode->container.insert(key);
            oldNode->container.erase(key);

            if(oldNode->container.empty()){
                List.erase(oldNode);
            }
            kv[key] = newNode;
        } else {
            auto newNode = List.begin();
            if(List.empty() || List.begin()->val>1)
                newNode = List.insert(List.begin(), Node(1));
            newNode->container.insert(key);
            kv[key] = newNode;
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    void dec(string key) {
        if(kv.count(key)){
            auto oldNode = kv[key];
            if(oldNode->val==1) {
                kv.erase(key);
            } else {
                auto newNode = next(oldNode, -1);
                if(oldNode==List.begin() || newNode->val<oldNode->val-1){
                    newNode = List.insert(oldNode, Node(oldNode->val-1));
                }
                newNode->container.insert(key);
                kv[key] = newNode;
            }

            oldNode->container.erase(key);
            if(oldNode->container.empty()){
                List.erase(oldNode);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    string getMaxKey() {
        if(List.empty()) return "";
        return *List.rbegin()->container.begin();
    }

    /** Returns one of the keys with Minimal value. */
    string getMinKey() {
        if(List.empty()) return "";
        return *List.begin()->container.begin();
    }
};
 