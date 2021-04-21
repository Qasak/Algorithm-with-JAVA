#include<bits/stdc++.h>
using namespace std;


bool dfs(vector<int> &nums) {
    if(nums.empty()) return true;
    int cnt=0;
    for(int num:nums) {
        if(nums[0]==num)
            cnt++;
        else 
            break;
    }
    
    if(nums.size()%3 && cnt>=2) {
        vector<int> new_nums(nums.begin()+2, nums.end());
        if(dfs(new_nums)) return true;
    }
    
    if(cnt>=3) {
        vector<int> new_nums(nums.begin()+3, nums.end());
        if(dfs(new_nums)) return true;
    }
    
    if(count(nums.begin(), nums.end(), nums[0]+1)>0 && count(nums.begin(), nums.end(), nums[0]+2)>0) {
        vector<int> new_nums(nums.begin()+1, nums.end());
        
        new_nums.erase(find(new_nums.begin(), new_nums.end(), nums[0]+1));
        
        new_nums.erase(find(new_nums.begin(), new_nums.end(), nums[0]+2));
        if(dfs(new_nums)) return true;
    }
    
    return false;
}


bool hu(vector<int> nums, int x) {
    if(count(nums.begin(), nums.end(), x)==4)
        return false;
    nums.push_back(x);
    sort(nums.begin(), nums.end());
    return dfs(nums);
}

int main() {
    vector<int> nums, ans;
    for(int i=0;i<13;i++) {
        int tmp;
        cin>>tmp;
        nums.push_back(tmp);
    }
    for(int i=1;i<=9;i++) {
        if(hu(nums, i))
            ans.push_back(i);
    }

    if(ans.empty())
        cout<<"0";
    for(int i=0; i<ans.size();i++) {
        cout<<ans[i];
        cout<<(i==ans.size()-1 ? "" : " ");
    }

    return 0;
}