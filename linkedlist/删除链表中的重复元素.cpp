//递归

class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if(!head || !head->next) return head;
        if(head->val==head->next->val) {
            ListNode* p=head;
            while(p->next && p->val==p->next->val) p=p->next;
            return deleteDuplicates(p->next);
        } else {
            head->next=deleteDuplicates(head->next);
            return head;
        }
    }
};

//迭代
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if(!head || !head->next)    return head;
        ListNode* root=new ListNode(0);
        ListNode* p=root;
        p->next=head;
        while(p && p->next && p->next->next) {
            if(p->next->val == p->next->next->val) {
                ListNode*end=p->next->next;
                while(end && p->next->val == end->val) end=end->next;
                p->next=end;
            }
            else 
                p=p->next;
        }
        return root->next;
    }
};



