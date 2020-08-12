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
    ListNode* reverseList(ListNode* head) {
        if(!head||!head->next)
            return head;
        ListNode* newHead=reverseList(head->next);
        head->next->next=head;
        head->next=nullptr;
        return newHead;
    }
};

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
    ListNode* reverseList(ListNode* head) {
        ListNode* pre=nullptr;
        ListNode* cur=head;
        ListNode* nxt=head;
        while(cur) {
            nxt=cur->next;
            cur->next=pre;
            pre=cur;
            cur=nxt;
        }
        return pre;
    }
};