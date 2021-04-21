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
    vector<int> inorderTraversal(TreeNode* root) {
        stack<TreeNode*> s;
        while(root || !s.empty()) {
            while(root) {
                s.push(root);
                root=root->left;
            }
            root=s.top();
            ans.push_back(root->val);
            s.pop();
            root=root->right;
        }
        return ans;
    }
};