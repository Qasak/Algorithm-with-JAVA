struct ls{
    bool operator()(ListNode* a, ListNode* b) {
        return a->val > b->val;
    }
};

class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<ListNode*, vector<ListNode*>,ls> pq;
        ListNode* p=new ListNode(0);
        ListNode* head=p;
        for(auto l:lists) {
            if(l)
                pq.push(l);
        }
        while(!pq.empty()) {
            auto t=pq.top();
            pq.pop();
            p->next=t;
            p=p->next;
            if(t->next) 
                pq.push(t->next);
        }
        return head->next;
    }
};