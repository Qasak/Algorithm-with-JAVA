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
    int pre_idx;
    unordered_map<int, int> mp;
    TreeNode* dfs(int l, int r, vector<int>& preorder, vector<int>& inorder) {
        if(l>r) return nullptr;
        int mid=mp[preorder[pre_idx]];
        TreeNode* root=new TreeNode(inorder[mid]);
        pre_idx++;
        root->left=dfs(l, mid-1, preorder, inorder);
        root->right=dfs(mid+1, r, preorder, inorder);
        return root;
    }
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        int n=preorder.size();
        for(int i=0;i<n;i++)
            mp[inorder[i]]=i;
        pre_idx=0;
        return dfs(0, n-1, preorder, inorder);
        
    }
};