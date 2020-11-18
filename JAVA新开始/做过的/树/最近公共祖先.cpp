
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        dfs(root, nullptr, 0);
        return lca(p,q);
    }
private:
    unordered_map<int, TreeNode*> parents;
    unordered_map<int, int> depth;
    void dfs(TreeNode* node, TreeNode* p, int d) {
        if(!node) return;
        parents[node->val]=p;
        depth[node->val]=d;
        dfs(node->left, node, d+1);
        dfs(node->right, node, d+1);
    }
    TreeNode* lca(TreeNode* p, TreeNode* q) {
        while(depth[p->val]>depth[q->val])  p=parents[p->val];
        while(depth[q->val]>depth[p->val])  q=parents[q->val];
        while(p!=q) {
            p=parents[p->val];
            q=parents[q->val];
        }
        return p;
    }
};