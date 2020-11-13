class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        // 偶数节点头
        ListNode p = head;
        // 奇数节点头
        ListNode q = head.next;
        ListNode oddHead = q;
        //
        while(p.next != null && q.next != null) {
            p.next = p.next.next;
            q.next = q.next.next;
            p = p.next;
            q = q.next;
        }
        p.next = oddHead;
        return dummy.next;
    }
}