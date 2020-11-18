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

class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode*  dummy = new ListNode(-1);
        dummy->next = head;  //虚拟头节点
        ListNode* p = dummy; //快指针
        ListNode* q = dummy; //慢指针
        while(n --) p = p->next; 
        while(p->next) { //追赶
            p = p->next;
            q = q->next;
        }
        q->next = q->next->next; //删除节点
        return dummy->next;
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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* dummy = new ListNode(-1);
        dummy->next=head;
        ListNode* fast, *slow;
        fast=slow=dummy;
        while(n--) {
            fast=fast->next;
        }
        while(fast && fast->next) {
            fast=fast->next;
            slow=slow->next;
        }
        slow->next=slow->next->next;
        return dummy->next;
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
    ListNode* getKthFromEnd(ListNode* head, int k) {
        ListNode* fast, *slow;
        fast=slow=head;
        k--;
        while(k--) {
            fast=fast->next;
        }
        while(fast && fast->next) {
            fast=fast->next;
            slow=slow->next;
        }
        return slow;
    }
};