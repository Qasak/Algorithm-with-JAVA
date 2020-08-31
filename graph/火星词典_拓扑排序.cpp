class Solution {
private:
    int cnt;
    vector<int> in_degree;
    vector<vector<int>> graph;
    
    bool init_graph(vector<string>& words) {
        for (char c : words[0]) {
            if (in_degree[c - 'a'] == -1) {
				++cnt;
				in_degree[c - 'a'] = 0;
			} 
		}			

        for (int i = 0; i < words.size() - 1; i++) {
            for (char c : words[i + 1]) {
                if (in_degree[c - 'a'] == -1) {
					++cnt;
					in_degree[c - 'a'] = 0;
				}
			}
			if(words[i].size()>words[i+1].size() && words[i].find(words[i+1])==0)
				return false;
            for (int j = 0; j < words[i].size(); j++) {
                char from = words[i][j];
				char to = words[i + 1][j];
                if (from != to) {
					graph[from - 'a'].push_back(to - 'a');
					in_degree[to - 'a']++;
					break;
				}
            }
        }
		return true;
    }
    
    string topology_sort() {
        string ans = "";
        queue<int> q;
        for (int i = 0; i < in_degree.size(); i++) {
            if (in_degree[i]==0) {
				q.push(i);
				ans += (i + 'a');
			}
        }
        
        while (!q.empty()) {
			int from = q.front(); 
			q.pop();
			for (int to : graph[from]) {
				in_degree[to]--;
				if (in_degree[to] == 0) {
					q.push(to);
					ans += (to + 'a');
				}
				
			}
        }
        
        return ans.size() == cnt ? ans : "";
    }
    
public:
    Solution():cnt (0), in_degree(26, -1), graph(26) {}
    
    string alienOrder(vector<string>& words) {
        
        if(!init_graph(words))
			return "";
        
        return topology_sort();
    }
};
