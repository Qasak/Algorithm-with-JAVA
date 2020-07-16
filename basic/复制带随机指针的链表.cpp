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
    const int offset=10000;
    const int mo=1007;
    Node* dfs[1<<15]={0};
    Node* copyRandomList(Node* head) {
        if(!head) return NULL;
        if(dfs[(long long)head%mo]) 
            return dfs[(long long)head%mo];
        Node* p=new Node(head->val);
        dfs[(long long)head%mo]=p;
        p->next=copyRandomList(head->next);
        
        Node* ran=head->random;
        if(ran) { 
            int r_val=ran->val;
            if(!dfs[(long long)ran%mo]) { // random节点未创建:创建后接上
                p->random=copyRandomList(ran); // 参数是啥？
            } else { // random节点已创建:直接接上
                p->random=dfs[(long long)ran%mo];
            } 
        } else {
            p->random=NULL;
        }
        return p;
    }
};