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
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        while(headA) {
            ListNode* B=headB;
            while(B) {
                if(headA==B)
                    return B;
                B=B->next;
            }
            headA=headA->next;
        }
        return nullptr;
    }
};
// set
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        set<ListNode*> s;
        while(headA) {
            s.insert(headA);
            headA=headA->next;
        }
        while(headB) {
            if(s.find(headB)!=s.end())
                return headB;
            headB=headB->next;
        }
        return nullptr;
    }
};

// 双指针
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode* pa=headA;
        ListNode* pb=headB;
        while(pa!=pb) {
            pa=pa==nullptr?headB:pa->next;
            pb=pb==nullptr?headA:pb->next;
        }
        return pa;
    }
};



