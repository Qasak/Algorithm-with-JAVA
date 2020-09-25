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
    int root_idx;
    unordered_map<int, int> mp;
public:
    TreeNode* dfs(int l, int r, vector<int>& inorder, vector<int>& postorder) {
        if(l>r) return nullptr;
        int mid=mp[postorder[root_idx]];
        TreeNode* head=new TreeNode(postorder[root_idx]);
        root_idx--;
        head->right=dfs(mid+1,r,inorder,postorder);
        head->left=dfs(l, mid-1, inorder, postorder);
        return head;
    }
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        int n=inorder.size();
        for(int i=0;i<n;i++)
            mp[inorder[i]]=i;
        root_idx=n-1;
        return dfs(0, n-1, inorder, postorder);
    }
};