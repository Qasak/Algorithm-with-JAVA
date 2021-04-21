package leetcode.template.Sort;

import java.util.Random;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/22 13:04
 */
public class Q215 {
    public Random rand;
    public int findKthLargest(int[] nums, int k) {
        rand = new Random();
        return selectKth(nums, 0, nums.length - 1, nums.length - k);
    }
    public int selectKth(int[] nums, int l, int r, int idx) {
        int p = randomPartition(nums, l, r);
        if(p == idx) {
            return nums[p];
        }
        return p < idx ? selectKth(nums, p + 1, r, idx) : selectKth(nums, l, p - 1, idx);
    }
    public int randomPartition(int[] nums, int l, int r) {
        int x = rand.nextInt(r - l + 1);
        swap(nums, r, l + x);
        return partition(nums, l, r);
    }
    public int partition(int[] nums, int l, int r) {
        int i = l - 1;
        for(int j = i + 1; j < r; j++) {
            if(nums[j] < nums[r]) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, ++i, r);
        return i;
    }
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int x = r.nextInt(200);
        System.out.println(x);
    }
}
