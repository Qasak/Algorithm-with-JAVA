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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if(!head)
            return head;

        ListNode* p1=new ListNode(0);
        p1->next=head;
        ListNode* p2=p1;
        n++;
        while(n--) {
            p2=p2->next;
        }
        while(p2) {
            p1=p1->next;
            p2=p2->next;
        }
        if(p1->next==head) {
            p1->next=head->next;
            delete head;
            return p1->next;
        }
        ListNode* pn=p1->next;
        p1->next=pn->next;
        delete pn;
        return head;
    }
};