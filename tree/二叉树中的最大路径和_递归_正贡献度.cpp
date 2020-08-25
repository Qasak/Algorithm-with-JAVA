/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
private:
    int val=1<<31;
public:

    int traverse(TreeNode* node) {
        if(!node) return 0;
        int left=max(traverse(node->left),0);
        int right=max(traverse(node->right),0);
        int node_price=node->val+left+right;
        val=max(val, node_price);
        return max(node->val+max(left,right), 0);
    }
    int maxPathSum(TreeNode* root) {
       traverse(root);
       return val;
    }
};