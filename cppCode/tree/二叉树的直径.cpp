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
public:
    int max_nodes;
    int depth(TreeNode* node) {
        if(!node) {
            return 0;
        }
        int left=depth(node->left);
        int right=depth(node->right);
        max_nodes=max(max_nodes, left+right+1);
        return max(left, right) + 1;
    }
    int diameterOfBinaryTree(TreeNode* root) {
        max_nodes=1;
        depth(root);
        return max_nodes-1;
    }
};