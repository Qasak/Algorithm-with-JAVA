package leetcode.template.BIT;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/6 15:26
 */
public class Q307_BIT_API {
    class NumArray {
        int[] a;
        int[] c;
        public NumArray(int[] nums) {
            int n = nums.length;
            a = nums;
            c = new int[n + 5];
            for(int i = 0; i < n; i++) {
                _update(i + 1, a[i]);
            }
        }
        public void _update(int id, int val) {
            while(id < c.length) {
                c[id] += val;
                id += id & (-id);
            }
        }

        public void update(int idx, int val) {
            int diff = val - a[idx];
            a[idx] = val;
            _update(idx + 1, diff);
        }
        public int sumRange(int i, int j) {
            return query(j + 1) - query(i);
        }
        // query(id): id及之前的数的前缀和
        private int query(int id) {
            int ret = 0;
            while(id > 0) {
                ret += c[id];
                id -= id & (-id);
            }
            return ret;
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
}

