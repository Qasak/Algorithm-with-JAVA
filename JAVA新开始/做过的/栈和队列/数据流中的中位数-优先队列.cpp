class MedianFinder {
public:
    /** initialize your data structure here. */
    priority_queue<int, vector<int>, less<int>> maxHeap; // 大顶
    priority_queue<int, vector<int>, greater<int>> minHeap; // 小顶
    MedianFinder() {

    }
    
    void addNum(int num) { 
        if(maxHeap.size()>minHeap.size()){
            maxHeap.push(num);
            minHeap.push(maxHeap.top());
            maxHeap.pop();
        }else{
            minHeap.push(num);
            maxHeap.push(minHeap.top());
            minHeap.pop();
        }
    }
    
    double findMedian() {
        if(maxHeap.size()==minHeap.size())
            return (double) (minHeap.top()+maxHeap.top())/2;
        else
            return (double) maxHeap.top();
    }
};