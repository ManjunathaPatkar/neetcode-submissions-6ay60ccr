class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        min.offer(num);
        max.offer(min.poll());
        if(max.size()>min.size()){
            min.offer(max.poll());
        }
    }
    
    public double findMedian() {
        if((min.size()+max.size())%2==0){
            return (double)(min.peek()+max.peek())/2;
        }
        else{
            return min.peek()/1.0;
        }
    }
}
