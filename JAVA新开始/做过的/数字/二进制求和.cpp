class Solution {
public:
    string addBinary(string a, string b) {
        int n=a.size();
        int m=b.size();
        string longer,shorter;
        if(n>m) {longer=a;shorter=b;}
        else {longer=b;shorter=a;}
        for(int i=shorter.size()-1,j=longer.size()-1;i>=0;i--, j--) {
            longer[j]+=shorter[i]-'0';
        }
        for(int i=longer.size()-1;i>0;i--) {
            if(longer[i]>'1') {
                longer[i]-=2;
                longer[i-1]+=1;
            }
        }
        if(longer[0]>'1') {
            longer[0]-=2;
            longer="1"+longer;
        }

        return longer;
    }
};