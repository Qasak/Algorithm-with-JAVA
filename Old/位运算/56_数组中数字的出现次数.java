// 相同的数异或为0，不同的异或为1。0和任何数异或等于这个数本身。
// 所以，数组里面所有数异或 = 目标两个数异或
// 由于这两个数不同，所以异或结果必然不为0。
// 假设数组异或的二进制结果为10010，那么说明这两个数从右向左数第2位是不同的


// 那么可以根据数组里面所有数的第二位为0或者1将数组划分为2个。

// 这样做可以将目标数必然分散在不同的数组中，而且相同的数必然落在同一个数组中。

// 这两个数组里面的数各自进行异或，得到的结果就是答案
class Solution {
    public int[] singleNumbers(int[] nums) {
        // x保存 a，b异或的结果
        int x = 0;
        for(int j : nums) {
            x ^= j;
        }
        // y保存a 或 b 的值
        // 算出y后，自然 另一个数为 x ^ y 
        int y = 0;
        // lowbit: 用于分组（因为x = a ^ b, 在lowbit位，a, b 是不同的），将数组分为：lowbit为1的和lowbit不为1的，a。b分别在这两组中
        int lowbit = x & (-x);
        // 瞄准其中一组，不断异或，由于其他数都是重复的，最后只会剩下那个唯一的数
        for(int j : nums) {
            if((j & lowbit) == 0) {
                y ^= j;
            }
        }
        return new int[] {y, x ^ y};

    }
}
// set思路：
// set转成int流，再转成数组即可
class Solution {
    public int[] singleNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums) {
            if(!set.contains(i)) {
                set.add(i);
            } else {
                set.remove(i);
            }
        }
        int[] ans = set.stream().mapToInt(m -> m).toArray();
        return ans;
    }
}