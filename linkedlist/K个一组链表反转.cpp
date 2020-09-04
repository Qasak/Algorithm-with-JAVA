/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* reverse_internal(ListNode* a, ListNode* b) {
        ListNode *pre, *cur, *nxt;
        pre=nullptr;
        cur=nxt=a;
        while(cur!=b) {
            nxt=cur->next;
            cur->next=pre;
            pre=cur;
            cur=nxt;
        }
        return pre;
    }
    ListNode* reverseKGroup(ListNode* head, int k) {
        if(!head) return nullptr;
        ListNode* a, *b;
        a=b=head;
        for(int i=0; i<k; i++) {
            if(!b) return head;
            b=b->next;
        }
        ListNode* new_head = reverse_internal(a,b);
        a->next=reverseKGroup(b, k);
        return new_head;
    }
};