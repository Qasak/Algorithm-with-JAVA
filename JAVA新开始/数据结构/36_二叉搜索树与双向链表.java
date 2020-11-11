/**输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
要求不能创建任何新的节点，只能调整树中节点指针的指向。
当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继
*/
// 排序的循环双向链表：
/*
1.排序链表：节点从小到大:对于BST应使用中序遍历
2.循环链表：head->left = tail
			tail->right = head
3.双向链表：构建相邻节点时，pre.right=cur, cur.left=pre
**/

/*
递归中序遍历
dfs(cur)

步骤：
1.节点cur空：越过了叶子节点直接返回
2.递归左子树dfs(cur.left)
3.构建链表：
	1.当pre为空时，正在访问头节点，记为head(?)
	2.当pre不为空时，修改双向节点引用：pre.right = cur; cur.left = pre
	3.保存cur, 更新cur: pre = cur
4.递归右子树dfs(cur.right)

treeToDoubleList(root):
1.特殊处理：root为空，直接返回
2.初始化：pre为空节点
3.转化为双向链表：调用dfs(root)
4.构建循环链表：中序遍历完成后，head指向头节点，pre指向尾节点，修改head，pre的引用
5.返回头节点
**/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    private Node head, pre;
    public Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }
        dfs(root);
        // 首位相连
        head.left = pre;
        pre.right = head;
        return head;

    }
    private void dfs(Node cur) {
        // 越界
        if(cur == null) {
            return;
        }
        // 左走
        dfs(cur.left);
        // init
        // 一开始pre是null, 到达此处说明访问到了树的左下角，最小值，设head = cur
        if(pre == null) {
            head = cur;
        // 在中间时
        } else {
            cur.left = pre;
            pre.right = cur;
        }
        // cur遵循中序的顺序，牵引pre前进
        pre = cur;
        // 右走
        dfs(cur.right);
    }
}