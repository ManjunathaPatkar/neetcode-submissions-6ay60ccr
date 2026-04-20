class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        return helper(word1,word2,0,0,m,n,new int[m][n]);
    }
    private int helper(String word1,String word2,
                    int i,int j,int m,int n, int[][] dp){
        if(j==word2.length()){
            return word1.length()-i;
        }
        if(i==word1.length()){
            return word2.length()-j;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        if(word1.charAt(i)==word2.charAt(j)){
            dp[i][j]= helper(word1,word2,i+1,j+1,m,n,dp);
        }
        else{
            int delete =  helper(word1,word2,i+1,j,m,n,dp);
            int replace = helper(word1,word2,i+1,j+1,m,n,dp);
            int insert = helper(word1,word2,i,j+1,m,n,dp);
            dp[i][j]=1+Math.min(delete,Math.min(replace,insert));
        }
        return dp[i][j];
    }
}
