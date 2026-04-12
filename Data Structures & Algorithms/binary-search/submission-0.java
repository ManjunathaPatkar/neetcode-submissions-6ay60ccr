class Solution {
    public int search(int[] nums, int target) {
        int j = nums.length-1, i =0;
        while(i<=j){
            int m = (i+j)/2;
            if(nums[m]==target){
                return m;
            }
            else if (nums[m]>target){
                j=m-1;
            }
            else{
                i=m+1;
            }
        }
        return -1;
    }
}
