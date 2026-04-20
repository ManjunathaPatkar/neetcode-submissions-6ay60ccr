class Solution {
    int count;
    public int numDistinct(String s, String t) {
        int[][] dp =new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(s,t,0,0,dp);
    }
    private int helper(String s, String t, int i, int j, int[][] dp){
        if(j==t.length()){
            return 1;
        }
        if(i==s.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==t.charAt(j)){
            int take = helper(s,t,i+1,j+1,dp);
            int skip = helper(s,t,i+1,j,dp);
            dp[i][j]=take+skip;
            return dp[i][j];
        }
        else{
            dp[i][j] = helper(s,t,i+1,j,dp);
            return dp[i][j];
        }
    }
}
