class Solution {
    public int findMin(int[] nums) {
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
        return nums[i];
    }
}

//  0,1,2,3,4,5
// [3,4,5,6,1,2]
// i      i   j

//  0,1,2,3,4,5
// [4,5,0,1,2,3]
//  i   j     