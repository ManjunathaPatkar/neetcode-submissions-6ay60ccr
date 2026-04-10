class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> hs = new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]== '.'){
                    continue;
                }
                if(!hs.add(board[i][j])){
                    return false;
                }
            }
            hs = new HashSet<>();
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[j][i]== '.'){
                    continue;
                }
                if(!hs.add(board[j][i])){
                    return false;
                }
            }
            hs = new HashSet<>();
        }
        for(int i=0;i<9;i=i+3){
            for(int j=0;j<9;j=j+3){
                if(!isValid(board,i,j)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int m, int n){
        Set<Character> hs = new HashSet<>();
        for(int i=m;i<m+3;i++){
            for(int j=n; j<n+3;j++){
                if(board[i][j]== '.'){
                    continue;
                }
                if(!hs.add(board[i][j])){
                    return false;
                }
            }
        }
        return true;
    }
}
