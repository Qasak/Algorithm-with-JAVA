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
    vector<int> ans;
    int level=0;
    bool used_level[1024]={false};
    vector<int> rightSideView(TreeNode* root) {
        if(root) {
            if(!used_level[level]) {
                ans.push_back(root->val);
                used_level[level]=true;
            }
            if(root->right) {
                ++level;
                rightSideView(root->right);
            }
            if(root->left) {
                ++level;
                rightSideView(root->left);
            }
        }
        --level;
        return ans;
    }
};