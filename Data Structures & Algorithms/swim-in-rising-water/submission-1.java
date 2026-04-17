class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] vis = new boolean[n][n];

        pq.offer(new int[]{grid[0][0], 0, 0}); // {maxSoFar, i, j}

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int max = cur[0], i = cur[1], j = cur[2];

            if (vis[i][j]) continue;
            vis[i][j] = true;

            if (i == n-1 && j == n-1) return max;

            for (int[] d : dir) {
                int ni = i + d[0], nj = j + d[1];

                if (ni >= 0 && nj >= 0 && ni < n && nj < n && !vis[ni][nj]) {
                    pq.offer(new int[]{
                        Math.max(max, grid[ni][nj]), ni, nj
                    });
                }
            }
        }

        return -1;
    }
}