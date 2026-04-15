class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        helper(board,n,res,0);
        return res;
    }

    private void helper(
        char[][] board, int n, List<List<String>> res,
        int row
    ){
        if(row==n){
            StringBuilder sb = new StringBuilder();
            List<String> l = new ArrayList<>();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    sb.append(board[i][j]);
                }
                l.add(sb.toString());
                sb = new StringBuilder();
            }
            res.add(l);
            return;
        }
        for(int col=0;col<n;col++){
            if(isSafe(board,row,col)){
                board[row][col]= 'Q';
                helper(board,n,res,row+1);
                board[row][col]= '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col){
        for(int j=0;j<board.length;j++){
            if(board[row][j]=='Q'){
                return false;
            }
        }
        for(int i=0;i<board.length;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        int i=row, j=col;
        while(i>=0 && j>=0){
             if(board[i][j]=='Q'){
                return false;
            }
            i--;
            j--;
        }
        i=row;
        j=col;
        while(i>=0 && j<board.length){
             if(board[i][j]=='Q'){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
