class Solution {
public:
    vector<vector<int>> ans;
    void dfs(TreeNode* root, int sum, int cur, vector<int> &tmp) {
        if(!root) return;
        cur+=root->val;
        tmp.push_back(root->val);
        if(cur==sum && !root->left && !root->right) {
            ans.emplace_back(tmp);
            tmp.pop_back();
            return;
        }
        dfs(root->left, sum, cur, tmp);
        dfs(root->right, sum, cur, tmp);
        tmp.pop_back();

    }
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        vector<int> tmp;
        dfs(root, sum, 0, tmp);
        return ans;
    }
};