class Solution {
public:
    string addStrings(string num1, string num2) {
        vector<int> A;
        vector<int> B;
        vector<int> C;
        string ans="";
        for(int i=num1.size()-1; i>=0; i--) A.push_back(num1[i]-'0');
        for(int i=num2.size()-1; i>=0; i--) B.push_back(num2[i]-'0');
        int t=0;
        for(int i=0; i<num1.size()|| i<num2.size(); i++) {
            if(i<num1.size()) t+=A[i];
            if(i<num2.size()) t+=B[i];
            C.push_back(t%10);
            t/=10;
        }
        if(t) C.push_back(t);
        for(int i=C.size()-1;i>=0;i--) ans.push_back(C[i]+'0');
        return ans;
    }
};