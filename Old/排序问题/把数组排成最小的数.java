//回溯：超时
class Solution {
    private String ans;
    private int n;
    public String minNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length; i++) {
            sb.append('9');
        }
        ans = sb.toString();
        n = nums.length;
        dfs(0, nums);
        return ans;
    }
    private void dfs(int idx, int[] nums) {
        String t = Arrays.stream(nums).boxed().map(Object::toString).reduce("", String::concat);
        if(t.compareTo(ans) > 0) {
            return;
        }
        if(idx == n) {
            StringBuilder sb = new StringBuilder();
            for(int i : nums) {
                String s = String.valueOf(i);
                sb.append(s);
            }
            if(sb.toString().compareTo(ans) < 0) {
                ans = sb.toString();
            }
            return;
        }
        for(int i = idx; i < n; i++) {

            swap(nums, i, idx);
            dfs(idx + 1, nums);
            swap(nums, i, idx);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
//排序
class Solution {
    public String minNumber(int[] nums) {
        Integer [] x  =  Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(x, (o1, o2) -> {
            String str1 = String.valueOf(o1);
            String str2 = String.valueOf(o2);
			// 30 3 : 303 < 330 
            return  (str1 + str2).compareTo(str2 + str1);
        });
        StringBuilder string = new StringBuilder();
        for(Integer num:x){
            string.append(num);
        }
        return string.toString();

    }
}
