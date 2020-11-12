/*
输入：[4,2,5,7]
输出：[4,5,2,7]

再奇数下标存奇数，偶数下标存偶数
**/

// 原地交换
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int p = 0, q = 1;
		// 不管奇偶性，小于最大的长度就行
        for(; p < A.length; p += 2) {
            // 当偶数下标是奇数时，与奇数下标是偶数的位置交换
            if((A[p] & 1) == 1) {
                // 奇数下标是奇数=>往后找，找到是偶数的位置，停
                while((A[q] & 1) == 1) {
                    q += 2;
                }
                int t = A[p];
                A[p] = A[q];
                A[q] = t;
            }
			// 否则 说明下标奇偶性和值的奇偶性相同
        }
        return A;
    }
}

// 1. p，q指向新数组的奇偶位置
// 2. 扫描当前数组，若为奇数，填到奇数指针的位置，指针往后挪；反之亦然
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int p = 0, q = 1;
        int[] ans = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            // 偶数
            if((A[i] & 1) == 0) {
                ans[p] = A[i];
                p += 2;
            } else {
                ans[q] = A[i];
                q += 2;
            }
        }
        return ans;
    }
}
