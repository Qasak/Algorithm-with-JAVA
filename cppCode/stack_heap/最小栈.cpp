class MinStack {
private:
    long min_val;
    const long inf=0x7fffffff;
    vector<long> s;
public:

    /** initialize your data structure here. */
    MinStack() {
        min_val=inf;
    }
    
    void push(int x) {
        s.push_back(x);
        min_val=min((long)x, min_val);
        return;
    }
    
    void pop() {
        long elem=*(s.end()-1);
        if(elem != min_val) {
            s.pop_back();
            return;
        }
        s.pop_back();
        if(s.empty())
            min_val=inf;
        else 
            min_val=*min_element(s.begin(), s.end());

        return;
    }
    
    int top() {
        return *(s.end()-1);
    }
    
    int getMin() {
        return min_val;
    }
};