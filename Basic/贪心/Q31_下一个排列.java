class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;
        for(int i = n - 1; i >= 1; i--) {
            if(nums[i] > nums[i - 1]) {
                idx = i - 1;
                break;
            }
        }
        if(idx == -1) {
            Arrays.sort(nums);
            return;
        }
        for(int i = n - 1; i > idx; i--) {
            if(nums[i] > nums[idx]) {
                swap(nums, i, idx);
                break;
            }
        }
        Arrays.sort(nums, idx + 1, n);
    }
    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}