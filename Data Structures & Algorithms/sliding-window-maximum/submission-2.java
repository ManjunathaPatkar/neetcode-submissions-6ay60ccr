class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
            int n=nums.length;
            int[] left=new int[n];
            int[] right=new int[n];
            left[0]=nums[0];
            right[n-1] =nums[n-1];

            for(int i=1;i<n;i++){
                left[i]=i%k==0?nums[i]:Math.max(left[i-1],nums[i]);
            } 

            for(int i=n-2;i>=0;i--){
                right[i]=i%k==0?nums[i]:Math.max(right[i+1],nums[i]);
            }

            int[] res=new int[n-k+1];

            for(int i=0;i<n-k+1;i++){
                res[i]=Math.max(right[i],left[i+k-1]);
            }  
            return res;
    }

}