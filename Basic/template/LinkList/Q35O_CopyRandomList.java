package leetcode.template.LinkList;

import leetcode.easy.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/23 10:11
 */
public class Q35O_CopyRandomList {
    // 1.递归+map
    Map<ListNode, ListNode> map = new HashMap<>();
    public ListNode copyRandomList(ListNode head) {

        if(head == null) {
            return head;
        }
        if(map.containsKey(head)) {
            return map.get(head);
        }
        ListNode newHead = new ListNode(head.val);
        map.put(head, newHead);
        newHead.random = copyRandomList(head.random);
        newHead.next = copyRandomList(head.next);
        return newHead;
    }
    // 2.map + 迭代
    public ListNode copyRandomList2(ListNode head) {
        if (head == null) {
            return head;
        }
        //map中存的是(原节点，拷贝节点)的一个映射
        Map<ListNode, ListNode> map = new HashMap<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            map.put(cur, new ListNode(cur.val));
        }
        //将拷贝的新的节点组织成一个链表
        for (ListNode cur = head; cur != null; cur = cur.next) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
        }

        return map.get(head);
    }
    // 3.迭代:原地修改
    // 1.复制一个新的节点在原有节点之后，如 1 -> 2 -> 3 -> null 复制完就是 1 -> 1 -> 2 -> 2 -> 3 - > 3 -> null
    // 2.从头开始遍历链表，通过 cur.next.random = cur.random.next 可以将复制节点的随机指针串起来，
    // 当然需要判断 cur.random 是否存在
    public ListNode copyRandomList3(ListNode head) {
        if(head == null) {
            return head;
        }
        //将拷贝节点放到原节点后面，例如1->2->3这样的链表就变成了这样1->1'->2->2'->3->3'
        for(ListNode i = head; i != null; i = i.next.next) {
            ListNode j = new ListNode(i.val);
            j.next = i.next;
            i.next = j;
        }
        // 把拷贝节点的random指针安排上
        for(ListNode i = head; i != null; i = i.next.next) {
            if(i.random != null) {
                i.next.random = i.random.next;
            }
        }
        // 分离拷贝节点和原节点，变成1->2->3和1'->2'->3'两个链表，后者就是答案
        ListNode newHead = head.next;
        for(ListNode i = head, j = null; i.next != null;) {
            // j = i.next;
            // i.next = j.next;
            // j.next = j.next.next;
            j = i.next;
            i.next = j.next;
            i = j;
        }
        return newHead;
    }

}
