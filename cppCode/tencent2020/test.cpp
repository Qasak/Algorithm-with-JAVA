#include<bits/stdc++.h>
using namespace std;
class A 
{
public:
    // int i;
    virtual void Print() { } // 虚函数
    long long i;
};

class B
{
public:
    int n;
    void Print() { } 
};

int main() 
{
    string s="123";
    s.erase(s.begin()+1, s.end());
    cout<<s;
    return 0;
}
