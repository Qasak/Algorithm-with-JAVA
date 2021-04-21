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
        ListNode * dummy=new ListNode(0);
        ListNode * head=dummy;
        int t=0;
        while(l1 && l2) {
            t=l1->val+l2->val+t/10;
            dummy->next=new ListNode(t%10);
            dummy=dummy->next;
            l1=l1->next;
            l2=l2->next;
        }
        while(l1) {
            t=l1->val+t/10;
            dummy->next=new ListNode(t%10);
            dummy=dummy->next;
            l1=l1->next;
        }
        while(l2) {
            t=l2->val+t/10;
            dummy->next=new ListNode(t%10);
            dummy=dummy->next;
            l2=l2->next;
        }
        if(t>=10) {
            dummy->next=new ListNode(t/10);
        }
        return head->next;
    }
};