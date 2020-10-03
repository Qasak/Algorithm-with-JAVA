class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int j = 0;
        for(int elem : pushed) {
            stack.push(elem);
            while(j < popped.length && !stack.isEmpty() && popped[j] == stack.peek()) { // 当栈顶元素和出栈第一个元素相同，则弹出，出栈列表指针后移并继续判断
                stack.pop();
                j++;
            }
        }
        return j == popped.length; //判断出栈列表指针是否指向出栈列表末尾
    }
}