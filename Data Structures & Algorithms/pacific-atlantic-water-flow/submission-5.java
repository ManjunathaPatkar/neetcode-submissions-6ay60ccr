class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m =heights.length;
        int n =heights[0].length;
        boolean[][] temp1 = new boolean[m][n];
        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        for(int i=0;i<m;i++){
            q1.offer(new int[]{i,0});
            q2.offer(new int[]{i,n-1});
        }
        for(int j=0;j<n;j++){
            q1.offer(new int[]{0,j});
            q2.offer(new int[]{m-1,j});
        }
        bfs(q1,heights,temp1, new boolean[m][n]);
        boolean[][] temp2 = new boolean[m][n];
        bfs(q2,heights,temp2, new boolean[m][n]);
        List<List<Integer>> res= new ArrayList<>();
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(temp1[i][j] && temp2[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    private void bfs(Queue<int[]> q, int[][] heights, 
                    boolean[][] temp, boolean[][] visited){
        int m =heights.length;
        int n =heights[0].length;
        while(!q.isEmpty()){
            int[] p = q.poll();
            int i=p[0];
            int j=p[1];
            temp[i][j]= true;
            int curHeight = heights[i][j];
            if(i>0 && !visited[i-1][j] && heights[i-1][j]>=curHeight){
                visited[i-1][j] =true;
                q.offer(new int[]{i-1,j});
            }
            if(j>0 && !visited[i][j-1] && heights[i][j-1]>=curHeight){
                visited[i][j-1] =true;
                q.offer(new int[]{i,j-1});
            }
            if(i<m-1 && !visited[i+1][j] && heights[i+1][j]>=curHeight){
                visited[i+1][j] = true;
                q.offer(new int[]{i+1,j});
            }
            if(j<n-1 && !visited[i][j+1] && heights[i][j+1]>=curHeight){
                visited[i][j+1] =true;
                q.offer(new int[]{i,j+1});
            }
        }
    }
}
