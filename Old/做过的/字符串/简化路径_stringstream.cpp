class Solution {
public:
    string simplifyPath(string path) {
        stringstream is(path);
        vector<string> strs;
        string ans, tmp;

        while(getline(is, tmp, '/')) {
            if(tmp == "" || tmp == ".")
                continue;
            else if(tmp == ".." ) {
                if(!strs.empty())
                    strs.pop_back();
            }
            else {
                strs.push_back(tmp);
            }
        }
        if(strs.empty())
            return "/";
        for(string str:strs) {
            ans+='/'+str;
        }
        return ans;
    }
};