class Solution {
    bool init_graph(vector<string>& words,unordered_map<char, int> &in_degree, vector<vector<char>> &graph) {
        for (char c : words[0]) {
            if (in_degree[c] == -1) {
				++cnt;
				in_degree[c] = 0;
			} 
		}			

        for (int i = 0; i < words.size() - 1; i++) {
            for (char c : words[i + 1]) {
                if (in_degree[c] == -1) {
					++cnt;
					in_degree[c] = 0;
				}
			}
			if(words[i].size()>words[i+1].size() && words[i].find(words[i+1])==0)
				return false;
            for (int j = 0; j < words[i].size(); j++) {
                char from = words[i][j];
				char to = words[i + 1][j];
                if (from != to) {
					graph[from-'a'].push_back(to);
					in_degree[to]++;
					break;
				}
            }
        }
		return true;
    }
    
    string topology_sort(unordered_map<char, int> &in_degree, vector<vector<char>> &graph) {
        string ans = "";
        queue<char> q;
        for (auto &p:in_degree) {
            if (p.second==0) {
				q.push(p.first);
				ans += p.first;
			}
        }

        while (!q.empty()) {
			char from = q.front(); 
			q.pop();
			for (char to : graph[from-'a']) {
				in_degree[to]--;
				if (in_degree[to] == 0) {
					q.push(to);
					ans += to;
				}
			}
        }
        
        return ans.size() == cnt ? ans : "";
    }
    
public: 
	int cnt=0;   
    string alienOrder(vector<string>& words) {
		unordered_map<char, int> in_degree;
		for(char c='a';c<='z'; c++) 
            in_degree[c]=-1;
		vector<vector<char>> graph(26);
        if(!init_graph(words, in_degree, graph))
			return "";
        return topology_sort(in_degree, graph);
    }
};
