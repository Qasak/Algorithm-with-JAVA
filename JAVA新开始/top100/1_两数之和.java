class Solution {
    public int[] twoSum(int[] nums, int target) {
		// 哈希表保存访问过的元素及其下标
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
			// 如果哈希表中有访问过的元素值为target - 当前元素值，则其值+当前元素值即为target, 
			// 当前元素下标和该元素下标
            if(map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
			// 没有的话，当前元素作为访问过的元素放入哈希表
            map.put(nums[i], i);
        }
        return null;
    }
}