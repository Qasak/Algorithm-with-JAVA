class MinStack {
    private Deque<Integer> A;
    private Deque<Integer> B;

    /** initialize your data structure here. */
    // A是正常栈
    // B是最小栈
	// 每次入栈：A都要入，B加个判断，是否不比最顶上的大，是则入
	// 每次getMin：直接返回B最顶上的元素
	// 每次pop：A都要pop, B判断从A pop的元素是等于，是则出
    public MinStack() {
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        // 若最小栈为空，或者新元素 <= 最小元素，进最小栈
        if(B.isEmpty() || x <= getMin()) B.push(x);
        A.push(x);
    }
    
    public void pop() {
        // 若当前栈顶元素和最小元素相同, 抛出最小元素
        if(A.peek().equals(getMin())) 
            B.pop();
        A.pop();
    }
    
    public int top() {
        return A.peek();
    }
    
    public int getMin() {
        return B.peek();
    }
}