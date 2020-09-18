class Solution {
public:
    int ans;
    int kk;
    void dfs(TreeNode* root) {
        if(!root) return;
        dfs(root->right);
        kk--;
        if(kk==0) {
            ans=root->val;
            return;
        }
        dfs(root->left);
    }
    int kthLargest(TreeNode* root, int k) {
        kk=k;
        dfs(root);
        return ans;
    }
};