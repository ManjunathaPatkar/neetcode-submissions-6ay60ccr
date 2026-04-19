class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp =new int[prices.length][2];
        return helper(prices,0,1,dp);
    }

    private int helper(int[] prices, int i, int canBuy, int[][] dp){
        if(i>=prices.length){
            return 0;
        }
        if(dp[i][canBuy]!=0){
            return dp[i][canBuy];
        }
        if(canBuy==1){
            dp[i][canBuy]=Math.max(
                -prices[i]+helper(prices,i+1,0,dp),
                helper(prices,i+1,1,dp)
            );
        }
        else{
             dp[i][canBuy]=Math.max(
                prices[i]+helper(prices,i+2,1,dp),
                helper(prices,i+1,0,dp)
            );
        }
        return dp[i][canBuy];
    }
}
