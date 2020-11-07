class CQueue {
    // stack1假装是一个队列，那么它只能在尾部插入，在尾部删除，现在要求在头部删除
    // 想象把stack1的元素倒放入stack2，那么stack2顶部的元素就是要删除的队列头
    // 如果再添加元素，直接添加至stack1，不用管stack2
    // 因为，此时stack2中的元素始终是队列最前面的，不用管，要删除的时候直接删除
    // 当stack2为空：意味着需要取一段新的队列头，把stack1中的元素全部倒进去
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }
    // 加在队列尾部

    public void appendTail(int value) {
        stack1.push(value);
    }
    // 删除队列头
    public int deleteHead() {
		// 当stack2为空：意味着需要取一段新的队列头，把stack1中的元素全部倒进去
		// 若取不到东西，则说明这个队列为空，返回-1
		// 否则，把stack1中的元素全部倒进去
        if(stack2.isEmpty()) {
            if(stack1.isEmpty()) {
                return -1;
            } else {
                while(!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
        }
        return stack2.pop();
    }
}