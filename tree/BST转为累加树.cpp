class Solution {
public:
    int cur;
    void dfs(TreeNode* root) {
        if(!root) return;
        dfs(root->right);
        cur+=root->val;
        root->val=cur;
        dfs(root->left);
    }
    TreeNode* convertBST(TreeNode* root) {
        dfs(root);
        return root;
    }
};