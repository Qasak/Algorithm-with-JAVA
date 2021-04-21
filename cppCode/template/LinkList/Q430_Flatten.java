package leetcode.template.LinkList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/31 16:17
 */
public class Q430_Flatten {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    public Node flatten(Node head) {
        if(head == null ) {
            return head;
        }
        return flatten(head, null);
    }
    public Node flatten(Node head, Node pre) {
        if(head == null ) {
            return head;
        }
        head.prev = pre;
        if(head.child != null) {
            Node t = head.next;
            t = flatten(t, head);
            head.next = flatten(head.child, head);
            head.child = null;
            Node p = head.next;
            while(p.next != null) {
                p = p.next;
            }
            if(t != null) {
                t.prev = p;
                p.next = t;
            }
        } else {
            head.next = flatten(head.next, head);
        }
        return head;
    }
}
