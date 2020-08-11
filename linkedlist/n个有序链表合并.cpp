#include <iostream>
using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
};

ListNode* mergeTwoLists(ListNode* l1,ListNode* l2) {
    ListNode* root,* p1,* p2;
    ListNode* p=root;
    p1=l1->next;
    p2=l2->next;
    p=new ListNode;
    root=p;
    while(p1&&p2) {
        if(p1->val<p2->val) {
            p->next=p1;
            p=p->next;
            p1=p1->next;
        } else {
            p->next=p2;
            p=p->next;
            p2=p2->next;
        }
        
    }
    if(!p1) {
        p->next=p2;
        return root;
    }
    else {
        p->next=p1;
        return root;
    }
}

int main() {

    int n;
    cin>>n;
    ListNode* p[n];
    getchar();
    for(int i=0;i<n;i++) {
        int t;
        p[i]=new ListNode;
        ListNode* root;
        root=new ListNode;
        p[i]=root;
        while(1) {
            scanf("%d",&t);
            root->next=new ListNode(int(t));
            root=root->next;
            char c=getchar();
            if(c=='\n') break;
        }
    }
    for(int i=0;i<n-1;i++)
        p[i+1]=mergeTwoLists(p[i],p[i+1]);
    ListNode* root=p[n-1];
    root=root->next;
    while(root) {
        printf("%d ",root->val);
        root=root->next;
    }
    return 0;
}