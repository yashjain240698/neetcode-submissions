class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;;
    public MedianFinder() { 
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()){
            return (maxHeap.peek() + minHeap.peek())/2.0;
        } else {
            System.out.println(minHeap.peek() + " " + maxHeap.peek());
            return (double) maxHeap.peek();
        } 
    
    }
}
