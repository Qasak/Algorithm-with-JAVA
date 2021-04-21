package leetcode.template.Tree;

import leetcode.easy.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/19 15:56
 */
public class Q109 {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        return build(list, 0, list.size() - 1);
    }
    private TreeNode build(List<Integer> list, int l, int r) {
        if(l > r) {
            return null;
        }
        int m = (l + r + 1) >>> 1;
        TreeNode root = new TreeNode(list.get(m));
        root.left = build(list, l, m - 1);
        root.right = build(list, m + 1, r);
        return root;
    }
}
