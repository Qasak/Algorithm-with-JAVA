/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode* ans,*p;
        p=new ListNode();
        ans=p;
        while(l1&&l2) {
            if(l1->val<l2->val) {
                p->next=l1;
                p=p->next;
                l1=l1->next;
                
            } else {
                p->next=l2;
                p=p->next;
                l2=l2->next;
                
            }
        }
        if(!l1) {
            p->next=l2;
        } else {
            p->next=l1;
        }
        
        return ans->next;
    }
    ListNode* p[10005]={nullptr};
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        int n=lists.size();
        if(n==0) return nullptr;
        if(n==1) return lists[0];
        
        p[0]=lists[0];
        for(int i=1;i<n;i++) {
            
            p[i]=mergeTwoLists(p[i-1], lists[i]);
        }
        
        return p[n-1];
    }
};