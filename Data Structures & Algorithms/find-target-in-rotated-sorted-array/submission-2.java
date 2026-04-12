class Solution {
    public int search(int[] nums, int target) {
        int minEle = Integer.MAX_VALUE;
        int i=0, j=nums.length-1;
        while(i<j){
            int m = (i+j)/2;
            if(nums[m]>nums[j]){
                i=m+1;
            }
            else{
                j= m;
            }
        }
        int minIndex = i;
        i = nums[nums.length-1]>=target?minIndex:0;
        j = nums[nums.length-1]<target?minIndex:nums.length-1;
        while(i<=j){
           int m = (i+j)/2;
           if(nums[m]==target){
            return m;
           } 
           else if(nums[m]>target){
            j=m-1;
           }
           else{
            i=m+1;
           }
        }
        return -1;
    }
}

// [4,5,6,1,2,3]