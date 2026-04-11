class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = nums.length;
        int[] res = new int[n-k+1];
        for(int i=0;i<k;i++){
            pq.add(nums[i]);
        }
        int m=1,i=0,j=k;
        res[0] = pq.peek();
        while(j<n){
            pq.remove(nums[i]);
            pq.add(nums[j]);
            res[m]=pq.peek();
            i++;
            j++;
            m++;
        }
        return res;
    }
}
