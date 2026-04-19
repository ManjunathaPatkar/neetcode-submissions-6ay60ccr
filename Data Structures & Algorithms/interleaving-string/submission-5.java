class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        return helper(s1,s2,s3,0,0,0,new int[s1.length()+1][s2.length()+1])==1?true:false;
    }
    private int helper(String s1,String s2,String s3,
        int i,int j,int k,int[][] dp){
            if(k==s3.length() && i==s1.length() && j == s2.length()){
                return 1;
            }
            if(i>=s1.length() && j >= s2.length()){
                return -1;
            }
            if(dp[i][j]!=0){
                return dp[i][j];
            }
            char a = i<s1.length()?s1.charAt(i):'A';
            char b = j<s2.length()?s2.charAt(j):'A';
            char c = s3.charAt(k);
            if(a==c && b==c){
                int withi = helper(s1,s2,s3,i+1,j,k+1,dp);
                int withj=helper(s1,s2,s3,i,j+1,k+1,dp);
                if(withi==1 || withj==1){
                    dp[i][j]=1;
                }
                else{
                    dp[i][j]=-1;
                }
                return dp[i][j];
            }
            if(a==c){
                dp[i][j]= helper(s1,s2,s3,i+1,j,k+1,dp);
                return dp[i][j];
            }
            if(b==c){
                dp[i][j]= helper(s1,s2,s3,i,j+1,k+1,dp);
                return dp[i][j];
            }
            dp[i][j]=-1;
            return dp[i][j];
        }
}
