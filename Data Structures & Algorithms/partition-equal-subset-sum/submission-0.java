class Solution {
    public boolean canPartition(int[] nums) {
        int sum =0;
        for(int num:nums){
            sum=sum+num;
        }
        if(sum%2!=0){
            return false;
        }
        sum=sum/2;
        Arrays.sort(nums);
        return helper(nums,0,sum);
    }

    private boolean helper(int[] nums,int i, int sum){
        if(sum==0){
            return true;
        }
        if(sum<0 || i>=nums.length){
            return false;
        }
        return helper(nums,i+1,sum-nums[i]) || helper(nums,i+1,sum);
    }
}
