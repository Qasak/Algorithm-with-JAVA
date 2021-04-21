class Solution {
public:
    string multiply(string num1, string num2) {
        if(num1=="0" || num2=="0")
            return "0";
        string ans;
        int n=num1.size();
        int m=num2.size();
        int t=0;
        auto ans_arr=vector<int>(m+n, 0);
        for(int i=m-1;i>=0;i--) {
            int x=num2[i]-'0';
            for(int j=n-1;j>=0;j--) {
                int y=num1[j]-'0';
                cout<<ans_arr[i+j+1]<<endl;
                ans_arr[i+j+1]+=x*y;// important
                
            }
            
        }
        for(int i=m+n-1;i>0;i--) {
            ans_arr[i-1]+=ans_arr[i]/10;
            ans_arr[i]%=10;
        }
        int idx=ans_arr[0]==0 ? 1:0;
        while(idx<m+n) {
            ans.push_back(ans_arr[idx]+'0');
            idx++;
        }
        return ans;
    }
};