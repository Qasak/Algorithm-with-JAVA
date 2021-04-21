/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    struct Status{
        int val;
        ListNode* ptr;
        bool operator<(const Status r) const {
            return val>r.val;
        }
    };
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<Status> pq;
        ListNode* dummy=new ListNode(0);
        ListNode* head=dummy;
        for(auto l:lists) {
            if(l)
                pq.push({l->val, l});
        }
        while(!pq.empty()) {
            auto t=pq.top();
            pq.pop();
            dummy->next=t.ptr;
            dummy=dummy->next;
            if(t.ptr->next) 
                pq.push({t.ptr->next->val, t.ptr->next});
            
        }
        return head->next;
    }
};