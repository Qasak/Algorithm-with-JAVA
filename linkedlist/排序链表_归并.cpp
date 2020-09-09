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
    ListNode* sortList(ListNode* head) {
        if(!head)
            return head;
        return merge_sort(head);
    }
private:
    ListNode* merge_sort(ListNode *head) {
		if(!head->next) return head; // important: 还剩一个节点，直接返回
        ListNode* l1, *l2, *mid;
        mid=find_mid(head);
        l1=merge_sort(head);
        l2=merge_sort(mid);
        return merge_two_list(l1,l2);
    }
    ListNode* find_mid(ListNode* head) {
        ListNode *fast , *slow, *pre;
        fast=slow=head;
        pre=nullptr;
        while(fast && fast->next) {
            pre=slow;
            slow=slow->next;
            fast=fast->next->next;
        }
        pre->next=nullptr;
        return slow;
    }

    ListNode* merge_two_list(ListNode* l1, ListNode* l2) {
        if(!l1) return l2;
        if(!l2) return l1;
        if(l1->val<l2->val) {
            l1->next=merge_two_list(l1->next, l2);
            return l1;
        } else {
            l2->next=merge_two_list(l1,l2->next);
            return l2;
        }

    }
};