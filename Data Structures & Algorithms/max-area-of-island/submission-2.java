class Solution {
    int max=0, cur =0;
    public int maxAreaOfIsland(int[][] grid) {
        max=0;
        cur =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j);
                    if(cur>max){
                        max=cur;
                    }
                    cur =0;
                }
            }
        }
        return max;
    }
    private void dfs(int[][] grid, int i,int j){
        grid[i][j]=0;
        cur++;
        if(i>0 && grid[i-1][j]==1){
            dfs(grid,i-1,j);
        }
        if(j>0 && grid[i][j-1]==1){
            dfs(grid,i,j-1);
        }
        if(i<grid.length-1 && grid[i+1][j]==1){
            dfs(grid,i+1,j);
        }
        if(j<grid[i].length-1 && grid[i][j+1]==1){
            dfs(grid,i,j+1);
        }
    }
}
