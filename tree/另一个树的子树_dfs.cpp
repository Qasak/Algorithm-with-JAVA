/*
给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

示例 1:
给定的树 s:

     3
    / \
   4   5
  / \
 1   2
给定的树 t：

   4 
  / \
 1   2
返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。

示例 2:
给定的树 s：

     3
    / \
   4   5
  / \
 1   2
    /
   0
给定的树 t：

   4
  / \
 1   2
返回 false。

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/2020-top-interview-questions/xrgpr6/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
 
class Solution {
public:
    bool check(TreeNode* s, TreeNode* t) {
        if(!s && !t)
            return true;
        if((!s && t) || (s && !t) || (s->val!=t->val))
            return false;
        return check(s->left, t->left) && check(s->right, t->right);
    }
    bool dfs(TreeNode* s, TreeNode* t) {
        if(!s)
            return false;
        return check(s,t) || dfs(s->left, t) || dfs(s->right, t);
    }
    bool isSubtree(TreeNode* s, TreeNode* t) {
        return dfs(s, t);
    }
};


/*
时间复杂度：对于每一个 s 上的点，都需要做一次 DFS 来和 t 匹配，
匹配一次的时间代价是 O(t)，那么总的时间代价就是 O(∣s∣×∣t∣)。
故渐进时间复杂度为 O(∣s∣×∣t∣)。 
空间复杂度：假设 s 深度为 d_s ​ ，t 的深度为 d_t ​ ，
任意时刻栈空间的最大使用代价是 O(\max \{ d_s, d_t \})。
故渐进空间复杂度为 O(max{d s ​ ,d t ​ })。 
*/

