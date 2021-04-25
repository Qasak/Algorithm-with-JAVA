package leetcode.SpringRecruit.Tree;

import javafx.util.Pair;
import leetcode.template.Tree.TreeNode;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/13 10:29
 */
public class Q272_最接近的二叉搜索树值2 {
    // 1. 暴力完全遍历
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Pair<Integer, Double>> pq = new PriorityQueue<>((a, b) ->  (a.getValue() < b.getValue() ? -1 : 1));
        Deque<TreeNode> stk = new LinkedList<>();
        while(root != null || !stk.isEmpty()) {
            while(root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            // System.out.println(Math.abs(target - root.val));
            pq.add(new Pair<>(root.val, Math.abs(target - root.val)));
            root = root.right;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            list.add(pq.poll().getKey());
        }
        return list;
    }
    // 2.单调队列

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        System.out.println(Math.pow(2, 31));
    }


}
