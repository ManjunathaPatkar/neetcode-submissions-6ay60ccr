class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        q.offer(new int[]{0,0});
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,0);
        int res =0;
        int n = points.length;
        boolean[] vis =new boolean[n];
        while(!q.isEmpty()){
            int[] polled= q.poll();
            int w=polled[0];
            int u=polled[1];
            if(hm.getOrDefault(u,Integer.MAX_VALUE)<w){
                continue;
            }
            res=res+w;
            for(int v=0;v<n;v++){
                if(!vis[v]){
                    int distance = 
                    dis(points[u][0],points[u][1],points[v][0],points[v][1]);
                    if(hm.getOrDefault(v,Integer.MAX_VALUE)>distance){
                        hm.put(v,distance);
                        q.offer(new int[]{distance,v});
                    }
                }
            }
        }
        return res;
    }

    private int dis(int x1,int y1,int x2,int y2){
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
}

