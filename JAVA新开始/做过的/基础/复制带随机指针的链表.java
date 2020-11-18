
// 要求返回这个链表的 深拷贝。
// 深拷贝的意思是每当遇到一个新的未访问过的节点，你都需要创造一个新的节点。
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
	// 哈希表保存原节点和新节点映射
    unordered_map<Node*, Node*> nodes;
    Node* copyRandomList(Node* head) {
        if(!head) return nullptr;
		// 当前节点的新节点已经生成过
        if(nodes.count(head)) 
            return nodes[head];
		// 当前节点的新节点还未生成
		// 将值复制，创建新节点
        Node* p=new Node(head->val);
		// 记录到哈希表，有别的节点访问到，即返回
        nodes[head]=p;
		// 新节点的next和random和原节点指向的值相同
        p->next=copyRandomList(head->next);
        p->random=copyRandomList(head->random);
        return p;
    }
};

class Solution {
    HashMap<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        
        if(head == null) {
            return null;
        }
        if(map.get(head) != null) {
            return map.get(head);
        }
        Node p = new Node(head.val);
        map.put(head, p);
        p.next = copyRandomList(head.next);
        p.random = copyRandomList(head.random);
        return p;
    }
}