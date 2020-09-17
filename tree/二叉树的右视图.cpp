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
    bool used_level[14]={0};
    void dfs(TreeNode* root, int level) {
        if(!root) return;
        if(!used_level[level]) {
            used_level[level]=true;
            ans.push_back(root->val);
        }
        dfs(root->right, level+1);
        dfs(root->left, level+1);
    }
    vector<int> rightSideView(TreeNode* root) {
        dfs(root, 0);
        return ans;
    }
};