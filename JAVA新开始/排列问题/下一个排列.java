/*
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
**/

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n <= 1){
            return;
        }
        int i = n - 1;
        int j = n - 2;
        int k = n - 1;
        while(j >= 0) {
            if(nums[j] < nums[i]) {
                break;
            }
            i--;
            j--;
        }
        if(j == -1) {
            Arrays.sort(nums);
        } else {
            while(k >= i) {
                if(nums[k] > nums[j]) {
                    break;
                }
                k--;
            }
            int t = nums[k];
            nums[k] = nums[j];
            nums[j] = t;
            
            Arrays.sort(nums, i, n);
        }
    }
}