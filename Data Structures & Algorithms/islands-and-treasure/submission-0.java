class Solution {
    public void islandsAndTreasure(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==0){
                    dfs(grid,i,j,0);
                }
            }
        }
    }

    private void dfs(int[][] grid,int i,int j,int count){
        grid[i][j]=count;
        if(i>0 && grid[i-1][j]!=0 && grid[i-1][j]!=-1 && grid[i-1][j]>count+1){
            dfs(grid,i-1,j,count+1);
        }
        if(j>0 && grid[i][j-1]!=0 && grid[i][j-1]!=-1 && grid[i][j-1]>count+1){
            dfs(grid,i,j-1,count+1);
        }
        if(i<grid.length-1 && grid[i+1][j]!=0 && grid[i+1][j]!=-1 && grid[i+1][j]>count+1){
            dfs(grid,i+1,j,count+1);
        }
        if(j<grid[i].length-1 && grid[i][j+1]!=0 && grid[i][j+1]!=-1 && grid[i][j+1]>count+1){
            dfs(grid,i,j+1,count+1);
        }
    }
}
