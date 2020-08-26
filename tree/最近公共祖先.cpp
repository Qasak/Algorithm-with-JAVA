/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
typedef long long ll;
class Solution {
public:
    static const int MAX_V=1<<16;
    TreeNode* parents[MAX_V]={nullptr};
    ll depth[MAX_V]={0};
    void dfs(TreeNode* node, TreeNode* p, int d) {
        if(!node) return;
        parents[node->val+(1<<14)]=p;
        depth[node->val+(1<<14)]=d;
        dfs(node->left, node, d+1);
        dfs(node->right, node, d+1);
    }
    TreeNode* lca(TreeNode* p, TreeNode* q) {
        while(depth[p->val+(1<<14)]>depth[q->val+(1<<14)])  p=parents[p->val+(1<<14)];
        while(depth[q->val+(1<<14)]>depth[p->val+(1<<14)])  q=parents[q->val+(1<<14)];
        while(p!=q) {
            p=parents[p->val+(1<<14)];
            q=parents[q->val+(1<<14)];
        }
        return p;
    }
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        dfs(root, nullptr, 0);
        return lca(p,q);
    }
};