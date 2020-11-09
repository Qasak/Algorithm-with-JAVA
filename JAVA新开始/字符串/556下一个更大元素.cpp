class Solution {
public:
    vector<int> nums;
    int nextGreaterElement(int n) {
        string s=to_string(n);
        int m=s.size();
        int i=m-1;
        int j=m-2;
        while(j>=0) {
            if(s[j]<s[i])
                break;
            i--;
            j--;
        }
        int k=m-1;
        if(j>=0) {
            while(k>=i) {
                if(s[k]>s[j])
                    break;
                k--;
            }
            swap(s[k], s[j]);
            sort(s.begin()+i, s.end());
        } else 
            return -1;
        
        long long num=stoll(s);
        return num>INT_MAX ? -1: num;
    }
};