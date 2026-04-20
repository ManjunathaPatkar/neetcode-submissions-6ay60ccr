class Solution {
    public int maxCoins(int[] inums) {
        int n = inums.length+2;
        int[] nums = new int[n];
        int k=0;
        nums[k]=1;
        k++;
        for(int num:inums){
            nums[k]=num;
            k++;
        }
        nums[k]=1;
        return helper(nums,0,n-1,new int[n][n]);
    }

    private int helper(int[] nums,int left,int right,int[][] dp){
        if(left==right){
            return 0;
        }
        if(dp[left][right]!=0){
            return dp[left][right];
        }
        int ans =0;
        for(int i=left+1;i<right;i++){
            ans = Math.max(ans,
                 nums[left]*nums[i]*nums[right]+
                 helper(nums,left,i,dp)+
                 helper(nums,i,right,dp));
        }
        dp[left][right]=ans;
        return ans;
    }
}
