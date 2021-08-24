class Solution:
    def quickSort(self, nums, l, r):
        if(l >= r):
            return
        nums[r], nums[(l + r) // 2] = nums[(l + r) // 2], nums[r]
        i = l - 1
        j = l 
        k = r
        while(j < k):
            if(nums[j] < nums[r]):
                i += 1
                nums[i], nums[j] = nums[j], nums[i]
                j += 1
            elif(nums[j] > nums[r]):
                k -= 1
                nums[k], nums[j] = nums[j], nums[k]
            else:
                j += 1
        self.quickSort(nums, l, i)
        self.quickSort(nums, j, r)
    def sortArray(self, nums: List[int]) -> List[int]:
        self.quickSort(nums, 0, len(nums) - 1)
        return nums