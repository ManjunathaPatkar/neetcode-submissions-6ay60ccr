class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s,p,0,0,new Boolean[s.length()+1][p.length()+1]);
    }

    private boolean helper(String s,String p,int i,int j,Boolean[][] dp){
        if(j==p.length()){
            dp[i][j]=i==s.length();
            return dp[i][j];
        }

        if(dp[i][j]!=null){
            return dp[i][j];
        }
        boolean isCurMatch = i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
        if(j+1<p.length() && p.charAt(j+1)=='*'){
            dp[i][j]=helper(s,p,i,j+2,dp)|| 
            (isCurMatch && helper(s,p,i+1,j,dp));
            return dp[i][j];
        }
        else{
            dp[i][j]=isCurMatch && helper(s,p,i+1,j+1,dp);
        }
        return dp[i][j]; 
        
    }
}
