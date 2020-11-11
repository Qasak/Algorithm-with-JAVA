

class Solution {
    public int sumNums(int n) {
		// 不用if, 先赋一个boolean
        boolean flag = (n > 0) && (n += sumNums(n - 1)) > 0;
        return n;
    }
};

class Solution {
    public int sumNums(int n) {
        return IntStream.range(1,n+1).sum();
    }
};