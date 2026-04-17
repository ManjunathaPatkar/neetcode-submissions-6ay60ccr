class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] vis = new boolean[n][n];

        pq.offer(new int[]{grid[0][0], 0, 0}); // {maxSoFar, i, j}

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int max = cur[0], i = cur[1], j = cur[2];

            if (vis[i][j]) continue;
            vis[i][j] = true;

            if (i == n-1 && j == n-1) return max;

            if(i> 0 && !vis[i-1][j]){
                pq.offer(new int[]{Math.max(max,grid[i-1][j]),i-1,j});
            }
            if(j> 0 && !vis[i][j-1]){
                pq.offer(new int[]{Math.max(max,grid[i][j-1]),i,j-1});
            }
            if(i<grid.length-1 && !vis[i+1][j]){
                pq.offer(new int[]{Math.max(max,grid[i+1][j]),i+1,j});
            }
            if(j<grid[i].length-1 && !vis[i][j+1]){
                pq.offer(new int[]{Math.max(max,grid[i][j+1]),i,j+1});
            }
            
        }

        return -1;
    }
}