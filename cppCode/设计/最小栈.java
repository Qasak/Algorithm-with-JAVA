class MinStack {
    private Stack<Integer> A;
    private Stack<Integer> B;

    /** initialize your data structure here. */
    public MinStack() {
        A = new Stack<Integer>();
        B = new Stack<Integer>();
    }
    
    public void push(int x) {
        A.push(x);
        if(B.isEmpty() || B.peek() >= x) B.push(x);
    }
    
    public void pop() {
        if(A.peek().equals(B.peek())) // equals比较值 ,==比较内存
            B.pop();
        A.pop();
    }
    
    public int top() {
        return A.peek();
    }
    
    public int min() {
        return B.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//  class MinStack {
// public:
//     stack<int> A;//普通栈
//     stack<int> B;//最小栈
//     /** initialize your data structure here. */
//     MinStack() {

//     }
    
//     void push(int x) {
//         A.push(x); // 直接放入A
//         if(B.empty() || B.top()>=x) B.push(x); //B空或者该元素小于最小栈栈顶， push进B
//     }
    
//     void pop() {
//         if(A.top() == B.top()) B.pop(); // 若A栈顶是最小元素，B同步pop
//         A.pop();
//     }
    
//     int top() {
//         return A.top();
//     }
    
//     int min() {
//         return B.top(); // 返回最小栈栈顶元素
//     }
// };
