class Solution {
    class Node{
        int i;
        int j;
        Node(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Node> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    q.offer(new Node(i,j));
                }
            }
        }
        int count =0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size!=0){
                Node n =q.poll();
                int i=n.i;
                int j=n.j;
                if(i>0 && grid[i-1][j]==1){
                    grid[i-1][j]=2;
                    q.offer(new Node(i-1,j));
                }
                if(j>0 && grid[i][j-1]==1){
                    grid[i][j-1]=2;
                    q.offer(new Node(i,j-1));
                }
                if(i<grid.length-1 && grid[i+1][j]==1){
                    grid[i+1][j]=2;
                    q.offer(new Node(i+1,j));
                }
                if(j<grid[i].length-1 && grid[i][j+1]==1){
                    grid[i][j+1]=2;
                    q.offer(new Node(i,j+1));
                }
                size--;
            }
            count++;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return count==0?0:count-1;
    }
}
