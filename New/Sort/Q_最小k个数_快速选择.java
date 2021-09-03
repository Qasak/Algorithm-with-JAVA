class Solution {
    Random rand = new Random();
    public int[] smallestK(int[] arr, int k) {
        int n = arr.length;
        quickSelect(arr, 0, n - 1, k);
        int[] ans = new int[k];
        for(int i = 0 ; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }
    void quickSelect(int[] arr, int l, int r, int k) {
        if(l >= r) {
            return;
        }
        swap(arr, l + rand.nextInt(r - l + 1), r);
        int i = l - 1, j = l, p = r;
        while(i + 1 < p) {
            if(arr[j] <= arr[r]) {
                swap(arr, ++i, j++);
            } else {
                swap(arr, --p, j);
            }
        }
        swap(arr, p, r);
        if(p == k) {
            return;
        }
        quickSelect(arr, l, p - 1, k);
        quickSelect(arr, p + 1, r, k);
    }
    void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}