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
    ListNode *detectCycle(ListNode *head) {
        ListNode* fast, *slow;
        fast=slow=head;
        bool flag=true;
        while(fast && fast->next) {
            fast=fast->next->next;
            slow=slow->next;
            if(fast == slow) {
                flag=false;
                break;
            }
        }
        if(flag)
            return NULL;
        slow=head;
        while(fast!=slow) {
            fast=fast->next;
            slow=slow->next;
        }
        return fast;
    }
};