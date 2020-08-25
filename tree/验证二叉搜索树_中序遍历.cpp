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
    vector<int> vals;
    void traverse(TreeNode* root) {
        if(root->left)  traverse(root->left);

        vals.push_back(root->val);

        if(root->right) traverse(root->right);
    }
    bool isValidBST(TreeNode* root) {
        if(!root)
            return true;
        traverse(root);
        for(int i=0;i<vals.size()-1;i++) {
            if(vals[i]>=vals[i+1])
                return false;
        }
        return true;
    }
};