/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null || (head.child == null && head.next == null)) {
            return head;
        }
        helper(head);

        Node p = head;
        // while(p != null) {
        //     System.out.print(p.val + " " + ((p.child == null ? "_" : p.child.val)) + " : ");
        //     p = p.next;
        // }
        return head;
    }
    public Node helper(Node head) {
        if(head == null || (head.child == null && head.next == null)) {
            return head;
        }
        Node p = head;
        while(p.next!= null && p.child == null) {
            p = p.next;
        }
        if(p.child == null) {
            return p;
        }
        Node q = p.next;

        Node child = p.child;
        Node tail = helper(child);
        p.child = null;
        child.prev = p;
        p.next = child;
        if(q != null) {
            q.prev = tail;
            tail.next = q;
        }


        while(p.next != null) {
            p = p.next;
        }
        return p;
    }
}