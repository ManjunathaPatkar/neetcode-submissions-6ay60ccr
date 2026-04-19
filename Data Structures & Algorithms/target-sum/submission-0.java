class Solution {
    int count;
    public int findTargetSumWays(int[] nums, int target) {
        count=0;
        helper(nums,0,target);
        return count;
    }

    public void helper(int[] nums, int i, int target){
        if(i==nums.length){
            if(target==0){
                count++;
            }
            return;
        }
        helper(nums,i+1,target+nums[i]);
        helper(nums,i+1,target-nums[i]);
    }
}
