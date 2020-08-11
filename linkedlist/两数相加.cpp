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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* p1 = l1;
        ListNode* p2 = l2;
        ListNode* p3 = new ListNode(0);
        ListNode* h=p3;
        int t=0;
        while(p1||p2) {
            if(p1) {t+=p1->val;p1=p1->next;}
            if(p2) {t+=p2->val;p2=p2->next;}
            p3->val=t%10;
            t/=10;
            if(p1||p2) {
                p3->next=new ListNode(0);
                p3=p3->next;
            }
        }
        if(t) {
            p3->next=new ListNode(0);
            p3=p3->next;
            p3->val=t;
        }
            
        return h;
    }
};