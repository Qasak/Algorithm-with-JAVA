#include <iostream>
#include <string>
using namespace std;
// BHCJW[100|DASKDNKJWDNWCDWF]WQW[99|SDWQJCIQINSALQP]DQOJAX 
int main(){
    // string s;
    // cin>>s;
    // int i = 0;
    // while(i < s.length()){
    //     if(s[i] == ']'){
    //         int j = i;//j用来向前寻找与]相匹配的[
    //         int k = 0;//k用来记录'|'所在位置
    //         while(s[j] != '['){
    //             if(s[j] == '|')
    //                 k = j;
    //             j--;
    //         }
    //         int len = stoi(s.substr(j+1,k-j));
    //         string s1 = s.substr(k+1,i - k - 1);
    //         string s2;
    //         for(int si = 0; si < len; si++){//将识别到的括号内容进行解码
    //             s2 += s1;
    //         }
    //         s = s.replace(j,i-j+1,s2);
    //         i = j;//替换后i所指向的内容变化，从替换部分的头开始再寻找
    //     }
    //     i++;
    // }
    // cout<<s<<endl;
    string s="[100|||";
    cout<<stoi(s.substr(1,5));
}
