class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int res= nums[0];
        int curMax = nums[0] <0 ?0:nums[0];
        for(int i=1;i<nums.length;i++){
            curMax =curMax +nums[i];
            res = Math.max(res,curMax);
            curMax = curMax<0?0:curMax;
        }
        return res;
    }
}
