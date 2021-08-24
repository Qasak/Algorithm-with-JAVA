class Solution:
    def mergeSort(self, tmp, nums, l, r):
        if(l >= r):
            return
        m = (l + r) // 2
        self.mergeSort(tmp, nums, l, m)
        self.mergeSort(tmp, nums, m + 1, r)
        idx = l
        i = l
        j = m + 1
        while(i <= m and j <= r):
            if(nums[i] < nums[j]):
                tmp[idx] = nums[i]
                idx += 1
                i += 1
            else:
                tmp[idx] = nums[j]
                idx += 1
                j += 1
        while(i <= m):
            tmp[idx] = nums[i]
            idx += 1
            i += 1
        while(j <= r) :
            tmp[idx] = nums[j]
            idx += 1
            j += 1
        for k in range(l, r + 1):
            nums[k] = tmp[k]
    def sortArray(self, nums: List[int]) -> List[int]:
        n = len(nums)
        tmp = [0] * n
        self.mergeSort(tmp, nums, 0, n - 1)
        return nums