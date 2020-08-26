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
    vector<int> T;
    vector<int> S;
    const int MIN_INT=1<<31;
    void to_vec_pre(TreeNode* root, vector<int> &tmp) {
        if(!root) {
            tmp.push_back(MIN_INT);
            return;
        }
        tmp.push_back(root->val);
        to_vec_pre(root->left, tmp);
        // cout<<root->val<<endl;
        to_vec_pre(root->right, tmp);
    }
    void to_vec_post(TreeNode* root, vector<int> &tmp) {
        if(!root) {
            tmp.push_back(MIN_INT);
            return;
        }
        to_vec_post(root->left, tmp);
        // cout<<root->val<<endl;
        to_vec_post(root->right, tmp);
        tmp.push_back(root->val);
    }
    bool check() {
        int i,j;
        i=j=0;
        while(i<S.size()) {
            while(i<S.size() && S[i]!=T[j]) i++;
            while(i<S.size() && j < T.size() && S[i]==T[j]) {
                i++;
                j++;
            }
            if(j==T.size())
                return true;
            i=i-j+1;
            j=0;
        }
        return false;
    }
    bool isSubtree(TreeNode* s, TreeNode* t) {
        if(!s && !t) return true;
        if(!s) return false;
        if(!t) return false;

        to_vec_pre(s,S);
        // cout<<endl;
        to_vec_pre(t,T);
        bool flag1=check();
        S.clear();
        T.clear();
        to_vec_post(s,S);
        to_vec_post(t,T);
        bool flag2=check();
        return flag1 && flag2;

    }
};