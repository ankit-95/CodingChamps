class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.remove());
        if(minHeap.size() < maxHeap.size()){
                minHeap.add(maxHeap.remove());
        }
    }
    
    public double findMedian() {
        if(minHeap.size()<=maxHeap.size()){
            return (minHeap.peek() + maxHeap.peek()) /2.0;
        } else {
            return minHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */