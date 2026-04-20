class Solution {
    int max;
    public int longestIncreasingPath(int[][] matrix) {
        int m =matrix.length;
        int n=matrix[0].length;
        int[][] dp =new int[m][n];
        max=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int len = dfs(matrix,m,n,i,j,dp);
                max=Math.max(max,len);
            }
        }
        return max;
    }
    private int dfs(int[][] matrix,int m ,int n, int i, int j, int[][] dp){
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int curMax=1;
        if(i>0 && matrix[i-1][j]>matrix[i][j]){
            int len = 1+dfs(matrix,m,n,i-1,j,dp);
            curMax = Math.max(curMax,len);
        }
        if(j>0 && matrix[i][j-1]>matrix[i][j]){
            int len = 1+dfs(matrix,m,n,i,j-1,dp);
            curMax = Math.max(curMax,len);
        }
        if(i<m-1 && matrix[i+1][j]>matrix[i][j]){
            int len = 1+dfs(matrix,m,n,i+1,j,dp);
            curMax = Math.max(curMax,len);
        }
        if(j<n-1 && matrix[i][j+1]>matrix[i][j]){
            int len = 1+dfs(matrix,m,n,i,j+1,dp);
            curMax = Math.max(curMax,len);
        }
        dp[i][j]=curMax;
        return dp[i][j];
    }
}
