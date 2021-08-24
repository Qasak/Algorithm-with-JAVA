package leetcode.template.Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/12 10:15
 */
public class Q331_验证二叉树前序序列化 {
    // "插槽" ：插入一个非空节点后，占用上一个节点的一个插槽，并增加两个待填入插槽；插入一个空节点后，占用上一个节点的一个插槽
    public boolean isValidSerialization(String preorder) {
        String[] tmp = preorder.split("\\,");
        int n = tmp.length;
        Deque<Integer> stk = new LinkedList<>();
        stk.push(1);
        for(int i = 0; i < n; i++) {
            if(stk.isEmpty()) {
                return false;
            }
            if(tmp[i].equals("#")) {
                if(stk.peek() > 1) {
                    stk.push(stk.pop() - 1);
                } else {
                    stk.pop();
                }
            } else {
                if(stk.peek() > 1) {
                    stk.push(stk.pop() - 1);
                } else {
                    stk.pop();
                }
                stk.push(2);
            }
        }
        if(!stk.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean isValidSerialization1(String preorder) {
        String[] tmp = preorder.split(",");
        int cnt = 1;
        for (String s : tmp) {
            if (cnt == 0) {
                return false;
            }
            if ("#".equals(s)) {
                cnt--;
            } else {
                // cnt - 1 + 2
                cnt++;
            }
        }
        // 最后所有插槽恰好填满
        return cnt == 0;
    }
}
