class Solution {
    public int maxProfit(int[] prices) {
        int leftMin = prices[0];
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++){
            if(leftMin<prices[i]){
                maxProfit = Math.max(maxProfit,prices[i]-leftMin);
            }
            leftMin = Math.min(leftMin,prices[i]);
        }
        return maxProfit;
    }
}
