class Solution {
public:
    string minRemoveToMakeValid(string s) {
        if(s.empty())
            return s;
        stack<pair<char, int>> ss;
        int n=s.size();
        for(int i=0; i<n; i++) {
            char c=s[i];
            pair<char, int> tmp={c,i};
            if(c=='(') {
                ss.push(tmp);
            } else if(c==')') {
                if(!ss.empty()) {
                    if(ss.top().first=='(') {
                        ss.pop();
                    } else {
                        ss.push(tmp);
                    }
                } else {
                    ss.push(tmp);
                }
            }
        }
        while(!ss.empty()) {
            s.erase(s.begin()+ss.top().second);
            ss.pop();
        }
        return s;
    }
};