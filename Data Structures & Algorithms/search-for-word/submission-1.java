class Solution {
    boolean isFound;
    public boolean exist(char[][] board, String word) {
        isFound = false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean[][] visited = new boolean[board.length][board[i].length];
                    visited[i][j]=true;
                    helper(board,word,i,j,0,visited);
                    if(isFound){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void helper(
        char[][] board, String word,int i,int j,int k,boolean[][] visited
    ){
        if(isFound){
            return;
        }
        if(k==word.length()-1){
            isFound =true;
            return;
        }
        if(i>0 && !visited[i-1][j] && board[i-1][j]==word.charAt(k+1)){
            visited[i-1][j] = true;
            helper(board,word,i-1,j,k+1,visited);
            visited[i-1][j] = false;
        }
        if(j>0 && !visited[i][j-1] && board[i][j-1]==word.charAt(k+1)){
            visited[i][j-1] = true;
            helper(board,word,i,j-1,k+1,visited);
            visited[i][j-1] = false;
        }
        if(i<board.length-1 && !visited[i+1][j] && board[i+1][j]==word.charAt(k+1)){
            visited[i+1][j] = true;
            helper(board,word,i+1,j,k+1,visited);
            visited[i+1][j] = false;
        }
        if(j<board[i].length-1 && !visited[i][j+1] && board[i][j+1]==word.charAt(k+1)){
            visited[i][j+1] = true;
            helper(board,word,i,j+1,k+1,visited);
            visited[i][j+1] = false;
        }
    }
}
