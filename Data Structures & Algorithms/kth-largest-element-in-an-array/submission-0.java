class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int num:nums){
            if(pq.size()==k){
                if(pq.peek()<num){
                    pq.poll();
                    pq.offer(num);
                }
            }
            else{
                pq.offer(num);
            }
        }
        return pq.peek();
    }
}


// [2,3,1,5,4]

// [2,3,1,1,5,5,4]

// [4,5,5]