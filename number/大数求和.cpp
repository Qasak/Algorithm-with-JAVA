#include<iostream>
#include<algorithm>
using namespace std;
 
string add(string s1,string s2){
    string max=s1,min=s2;
    int i,j;
    if(s1.size()<s2.size()){
        max=s2;
        min=s1;
        }
 
    for(i=min.size()-1,j=max.size()-1;i>=0;i--,j--){
        max[j]+=min[i]-'0'; //先将min的所有位加到max的对应位上
    }
    for(i=max.size()-1;i>0;i--){
        if(max[i]>'9'){ //max的每一位是字符型
            max[i]-=10;
            max[i-1]++;
        }
    }
    if(max[0]>'9'){     //如果max的第一位>9的话，需要往前进一位，但是因为这已经是第一位了，所以加一个字符1
        max[0]=max[0]-10;
        max='1'+max;
    }
    return max;
}
int main(void)
{
    string s1,s2;
    cin>>s1>>s2;
    string s3=add(s1,s2);
    cout<<s3<<endl;
 
    return 0;
}