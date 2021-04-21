/*
dfn[ ]：就是一个时间戳（被搜到的次序），一旦某个点被DFS到后，这个时间戳就不再改变（且每个点只有唯一的时间戳）。所以常根据dfn的值来判断是否需要进行进一步的深搜。

low[ ]：追溯值用来表示从当前节点 x 作为搜索树的根节点出发，能够访问到的所有节点中，时间戳最小的值

*/

class Solution {
public:
    int times;
    vector<int> dfn;
    vector<int> low;
    vector<bool> used;
    vector<vector<int>> graph;
    vector<vector<int>> ret;
    void tarjan(int u, int parent) {
        dfn[u]=low[u]=++times;
        for(auto &v:graph[u]) {
            if(v!=parent) {
                if(!used[v]) {
                    used[v]=true;
                    tarjan(v, u);
                    low[u]=min(low[u], low[v]);
                    if(dfn[u]<low[v])
                        ret.push_back({u,v});
                } else {
                    low[u]=min(low[u], dfn[v]);
                }
            }
        }
    }
    vector<vector<int>> criticalConnections(int n, vector<vector<int>>& connections) {
        dfn=vector<int>(n);
        low=vector<int>(n);
        used=vector<bool>(n);
        graph=vector<vector<int>>(n);
        for(auto &conn:connections) {
            graph[conn[0]].push_back(conn[1]);
            graph[conn[1]].push_back(conn[0]);
        }
        tarjan(0, -1);
        return ret;
    }
};
