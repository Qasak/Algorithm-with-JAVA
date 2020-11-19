/*
输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
**/

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        // l指向非零序列的下一个元素， r指向当前元素，若r的元素不是0，则交换l,r元素
        // 该元素加入左边序列，l扩展一格，r扩展一格(不管是不是0)
        int l = 0, r = 0;
        while(r < n) {
            if(nums[r] != 0) {
                swap(nums, l, r);
                l++;
            }
            r++;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}