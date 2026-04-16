class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m =heights.length;
        int n =heights[0].length;
        int[][] temp = new int[m][n];
        boolean[][] visited = new boolean[m][n];
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
        while(!q1.isEmpty()){
            int[] p = q1.poll();
            int i=p[0];
            int j=p[1];
            temp[i][j]= 1;
            // visited[i][j]=true;
            int curHeight = heights[i][j];
            if(i>0 && !visited[i-1][j] && heights[i-1][j]>=curHeight){
                visited[i-1][j] =true;
                q1.offer(new int[]{i-1,j});
            }
            if(j>0 && !visited[i][j-1] && heights[i][j-1]>=curHeight){
                visited[i][j-1] =true;
                q1.offer(new int[]{i,j-1});
            }
            if(i<m-1 && !visited[i+1][j] && heights[i+1][j]>=curHeight){
                visited[i+1][j] = true;
                q1.offer(new int[]{i+1,j});
            }
            if(j<n-1 && !visited[i][j+1] && heights[i][j+1]>=curHeight){
                visited[i][j+1] =true;
                q1.offer(new int[]{i,j+1});
            }
        }
        visited = new boolean[m][n];
         int[][] temp2 = new int[m][n];
         while(!q2.isEmpty()){
            int[] p = q2.poll();
            int i=p[0];
            int j=p[1];
            temp2[i][j]= 1;
            // visited[i][j]=true;
            int curHeight = heights[i][j];
            if(i>0 && !visited[i-1][j] && heights[i-1][j]>=curHeight){
                visited[i-1][j] =true;
                q2.offer(new int[]{i-1,j});
            }
            if(j>0 && !visited[i][j-1] && heights[i][j-1]>=curHeight){
                visited[i][j-1] =true;
                q2.offer(new int[]{i,j-1});
            }
            if(i<m-1 && !visited[i+1][j] && heights[i+1][j]>=curHeight){
                visited[i+1][j] = true;
                q2.offer(new int[]{i+1,j});
            }
            if(j<n-1 && !visited[i][j+1] && heights[i][j+1]>=curHeight){
                visited[i][j+1] =true;
                q2.offer(new int[]{i,j+1});
            }
        }
        List<List<Integer>> res= new ArrayList<>();
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(temp[i][j]==1 && temp2[i][j]==1){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
        
    }
}
