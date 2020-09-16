//拷贝的意思是每当遇到一个新的未访问过的节点，你都需要创造一个新的节点。
/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    unordered_map<Node*, Node*> nodes;
    Node* copyRandomList(Node* head) {
        if(!head) return nullptr;
        if(nodes.count(head)) 
            return nodes[head];
        Node* p=new Node(head->val);
        nodes[head]=p;
        p->next=copyRandomList(head->next);
        p->random=copyRandomList(head->random);
        return p;
    }
};