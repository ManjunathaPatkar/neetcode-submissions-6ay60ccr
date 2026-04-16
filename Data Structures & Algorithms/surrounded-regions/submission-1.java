class Solution {
    public void solve(char[][] board) {
        int m=board.length, n = board[0].length;
        if(m==0 || n==0){
            return;
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                q.offer(new int[]{i,0});
            }
            if(board[i][n-1]=='O'){
                q.offer(new int[]{i,n-1});
            }
        }
        for(int j=0;j<n;j++){
            if(board[0][j]=='O'){
                q.offer(new int[]{0,j});
            }
            if(board[m-1][j]=='O'){
                q.offer(new int[]{m-1,j});
            }
        }
        boolean[][] vis=new boolean[m][n];
        while(!q.isEmpty()){
            int[] p =q.poll();
            int i=p[0],j=p[1];
            board[i][j]='Y';
            vis[i][j]=true;
            if(i>0 && !vis[i-1][j] && board[i-1][j]=='O'){
                vis[i-1][j]=true;
                q.offer(new int[]{i-1,j});
            }
            if(j>0 && !vis[i][j-1] && board[i][j-1]=='O'){
                vis[i][j-1]=true;
                q.offer(new int[]{i,j-1});
            }
            if(i<m-1 && !vis[i+1][j] && board[i+1][j]=='O'){
                vis[i+1][j]=true;
                q.offer(new int[]{i+1,j});
            }
            if(j<n-1 && !vis[i][j+1] && board[i][j+1]=='O'){
                vis[i][j+1]=true;
                q.offer(new int[]{i,j+1});
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='Y'){
                    board[i][j]='O';
                }
            }
        }
    }
}
