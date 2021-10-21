class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        // 1. 超过n / 3的元素最多两个
        // 2. 投票法 找到k个最多的数
        int a; int b;
        a = b = (int) 1e9 + 1;
        int cntA = 0, cntB = 0;
        // 与位置顺序无关
        // abcdaaaa
        for(int cur : nums) {
            // 注意判断顺序
            // 如果判0在前，则 a b 可能取到同一个数字
            if(cur == a) {
                cntA++;
            // a b 不是同一个数
            } else if(cur == b) {
                cntB++;
            } else if(cntA == 0) {
                a = cur;
                cntA++;
            } else if(cntB == 0) {
                b = cur;
                cntB++;
            } else {
                cntA--; cntB--;
            }
        }
        // check两个数量最大的数是否满足n / 3
        // System.out.println(a + " " + b);
        cntA = 0; cntB = 0;
        for(int cur : nums) {
            if(cur == a) {
                cntA++;
            }
            if(cur == b) {
                cntB++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if(cntA > n / 3) {
            ans.add(a);
        } 
        if(cntB > n / 3) {
            ans.add(b);
        }
        return ans;

        // 
    }
}