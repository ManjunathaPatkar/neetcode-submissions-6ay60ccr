class Solution {
    public int numIslands(char[][] grid) {
        int count =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i,int j){
        grid[i][j]='2';
        if(i>0 && grid[i-1][j]=='1'){
            grid[i-1][j]='2';
            dfs(grid,i-1,j);
        }
        if(i<grid.length-1 && grid[i+1][j]=='1'){
            grid[i+1][j]='2';
            dfs(grid,i+1,j);
        }
        if(j>0 && grid[i][j-1]=='1'){
            grid[i][j-1]='2';
            dfs(grid,i,j-1);
        }
        if(j<grid[i].length-1 && grid[i][j+1]=='1'){
            grid[i][j+1]='2';
            dfs(grid,i,j+1);
        }
    }
}
