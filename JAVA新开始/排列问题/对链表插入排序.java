class Solution {
    public ListNode insertionSortList(ListNode head) {
        if ( head == null || head.next == null)
            return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // p1 前一个节点
        ListNode p1 = head;
        ListNode p2 = head.next;
        // p2:当前节点
        while (p2 != null) {
            // 前一个节点大，需要交换
            if (p1.val > p2.val) {
                // 记录当前节点
                ListNode cur = p2;
                // 把当前节点移除
                p2 = p2.next;
                p1.next = p2;
                // 从头开始找
                ListNode p = dummy;
                while (p.next.val < cur.val) {
                    p = p.next;
                }
                // p.next是第一个比cur大的节点
                // 把cur插入p和p.next中间
                
                cur.next = p.next;
                p.next = cur;
                
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }

        return dummy.next;
    }
}