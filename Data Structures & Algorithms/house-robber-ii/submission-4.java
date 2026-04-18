class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int a =helper(nums,0,nums.length-2);
        int b=helper(nums,1,nums.length-1);
        return Math.max(a,b);
    }
    private int helper(int[] nums, int start, int end){
        int prev1=0,prev2=0;
        int cur = 0;
        for(int i=start;i<=end;i++){
            cur = Math.max(nums[i]+prev2,prev1);
            prev2=prev1;
            prev1=cur;
        }
        return prev1;
    }
}
