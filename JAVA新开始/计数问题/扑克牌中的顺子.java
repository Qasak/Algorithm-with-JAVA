// 纯模拟

class Solution {
    public boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums);
        for(int i : nums) {
            if(i == 0) {
                joker++;
            }
        }
        for(int i = joker + 1; i < 5; i++) {
            int diff = nums[i] - nums[i - 1];
            if(diff == 1) {
                continue;
            } else if(diff == 2) {
                if(joker < 1) {
                    return false;
                } else {
                    joker--;
                }
            } else if(diff == 3) {
                if(joker < 2) {
                    return false;
                } else {
                    joker -= 2;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}

// 遍历，数零，比零和差值的个数
class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroCnt=0,diff=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0){
                zeroCnt++;
            }else{
                if(nums[i]==nums[i+1]) return false;
                if(nums[i]+1!=nums[i+1]){
                    diff+=nums[i+1]-nums[i]-1;
                }
            }
        }
        return zeroCnt>=diff;
    }
}