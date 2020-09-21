#include <iostream>
#include <string>
using namespace std;
// HG[3|B[2|CA]]F
int main(){
    string s;
    cin>>s;
    int i = 0;
    while(i < s.length()){
        if(s[i] == ']'){
            int j = i;//j用来向前寻找与]相匹配的[
            int k = 0;//k用来记录'|'所在位置
            while(s[j] != '['){
                if(s[j] == '|')
                    k = j;
                j--;
            }
            int len = stoi(s.substr(j+1,k-j-1));
            string s1 = s.substr(k+1,i - k - 1);
            string tmp;
            while(len--) {
                tmp+=s1;
            }
            s = s.replace(j,i-j+1,tmp);
            i = j;//替换后i所指向的内容变化，从替换部分的头开始再寻找
        }
        i++;
    }
    cout<<s<<endl;
    return 0;
    // string s="[100|||";
    // cout<<stoi(s.substr(1,5));
}
