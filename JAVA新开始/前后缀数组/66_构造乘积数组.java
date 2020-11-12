//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。


class Solution {
    public int[] constructArr(int[] a) {
        int [] ans = new int[a.length];
        // 保存a[i]之前元素的前缀积
        int prod = 1;
        // ans保存前缀积
        for(int i = 0; i < a.length; i++) {
            ans[i] = prod;
            prod = prod * a[i];
        }
        // 保存a[i]之后的后缀积
        // ans保存i位置的前缀积与后缀积乘积，即为i之外元素的乘积
        prod = 1;
        for(int i = a.length - 1; i >= 0; i--) {
            // 先乘上后缀积，再把当前位置元素值乘到后缀积里面
            ans[i] = ans[i] * prod;
            prod = prod * a[i];
        }
        return ans;
    }
}