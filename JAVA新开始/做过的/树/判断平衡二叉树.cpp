class Solution {
public:

    int dfs(TreeNode* root, int h) {
        if(!root) return h;
        int hl=dfs(root->left, h+1);
        int hr=dfs(root->right, h+1);
        if(abs(hl-hr)>1)
            return INT_MAX;
        return max(dfs(root->left, h+1), dfs(root->right, h+1));

    }
    bool isBalanced(TreeNode* root) {
        if(!root) return true;
        if(dfs(root, 0)!=INT_MAX)
            return true;
        return false;
    }
};


class Solution {
public:
    int depth(TreeNode* root) {
        return !root ? 0 : max(depth(root->left)+1, depth(root->right)+1);
    }
    bool isBalanced(TreeNode* root) {
        return !root ? true : abs(depth(root->left)-depth(root->right))<=1 && isBalanced(root->left) && isBalanced(root->right);
    }
};