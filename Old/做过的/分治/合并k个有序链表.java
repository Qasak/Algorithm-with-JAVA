/*
给你一个链表数组，每个链表都已经按升序排列。

请你将所有链表合并到一个升序链表中，返回合并后的链表。
**/
// 1. 优先队列
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> que  = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode p = new ListNode(0);
        ListNode head = p;
        for(ListNode l : lists) {
            if(l != null) {
                que.add(l);
            }
        }
        while(!que.isEmpty()) {
            ListNode t = que.poll();
            p.next = t;
            p = p.next;
            if(t.next != null) {
                que.add(t.next);
            }
        }
        return head.next;
    }
}




// c++默认大顶堆
struct ls{
    bool operator()(ListNode* a, ListNode* b) {
        return a->val > b->val;
    }
};

class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<ListNode*, vector<ListNode*>,ls> pq;
		// 新建一个dummy节点
        ListNode* p=new ListNode(0);
        ListNode* head=p;
		// 所有链表的第一个节点加入优先队列
        for(auto l:lists) {
            if(l)
                pq.push(l);
        }
		
        while(!pq.empty()) {
			// 取最小的元素接在后面
            auto t=pq.top();
            pq.pop();
            p->next=t;
            p=p->next;
			// 如果这个链表没有结束，把下一个节点放入优先队列
            if(t->next) 
                pq.push(t->next);
        }
        return head->next;
    }
};