class Solution {
public:
	int quick_select(vector<int>& nums, int l, int r, int idx) {
		int p=random_partition(nums, l, r);
		if(p==idx)
			return nums[p];
		return p<idx ? quick_select(nums, p+1, r, idx):quick_select(nums, l, p-1, idx);
	}
	int random_partition(vector<int>& nums, int l, int r) {
		int i=rand() % (r-l+1) + l;
		swap(nums[i], nums[r]);
		return partition(nums, l, r);
	}
	int partition(vector<int>& nums, int l, int r) {
		int i=l-1;
		int x=nums[r];
		for(int j=l; j<r;j++) {
			if(nums[j]<x) {
				i++;
				swap(nums[i], nums[j]);
			}	
		}
		swap(nums[i+1], nums[r]);
		return i+1;
	}
    int findKthLargest(vector<int>& nums, int k) {
		srand(time(0));
		return quick_select(nums, 0, nums.size()-1, nums.size()-k);
    }
};