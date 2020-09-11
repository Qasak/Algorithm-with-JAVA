class Solution {
public:
    vector<double> averageOfLevels(TreeNode* root) {
        vector<double> ans;
        if(!root) return ans;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()) {
            int n=q.size();
            int m=n;
            double sum=0;
            while(n--) {
                auto t=q.front();
                q.pop();
                if(t->left) q.push(t->left);
                if(t->right) q.push(t->right);
                sum+=t->val;
            }
            ans.push_back(sum/m);
        }
        return ans;
    }
};