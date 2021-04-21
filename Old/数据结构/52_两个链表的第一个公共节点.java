public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa=headA;
        ListNode pb=headB;
        while(pa!=pb) {
			//两个节点同时开走，其中一个碰到空节点，直接换到另一个的头，一定能碰到一起
            pa=pa==null?headB:pa.next;
            pb=pb==null?headA:pb.next;
        }
        return pa;
    }
}


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while(headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while(headB != null) {
            if(set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}