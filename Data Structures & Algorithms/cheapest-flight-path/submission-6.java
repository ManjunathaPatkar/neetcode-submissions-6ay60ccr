class Solution {
    int min;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        min =Integer.MAX_VALUE;
        HashMap<Integer,List<int[]>> hm =new HashMap<>();
        for(int[] flight:flights){
            hm.putIfAbsent(flight[0],new ArrayList<>());
            hm.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        // for(int key :hm.keySet()){
        //     System.out.print("key "+key+" ");
        //     for(int[] node:hm.get(key)){
        //         System.out.print(node[0]+" : "+node[1]+" ");
        //     }
        //     System.out.println();
        // }
        boolean[] vis = new boolean[n];
        dfs(hm,src,dst,k,vis,0, new boolean[n]);
        return min==Integer.MAX_VALUE?-1:min;
    }

    private void dfs(HashMap<Integer,List<int[]>> hm, int src, int dst,
        int k,  boolean[] vis,int curCount, boolean[] rec){
            // rec[src]=true;
            // System.out.println(src+" "+dst+" "+k+" "+curCount);
            // for(int i=0;i<vis.length;i++){
            //     System.out.print(vis[i]+" ");
            // }
            //  System.out.println();
            if(src==dst && k>=-1){
                min = Math.min(min,curCount);
            }
            if(k<-1 || curCount>min){
                // System.out.println(k);
                // rec[src]=false;
                return;
            }
            if(hm.containsKey(src)){
                for(int[] adj:hm.get(src)){
                    // if(!rec[adj[0]]&& !vis[adj[0]]){
                        dfs(hm,adj[0],dst,k-1,vis,curCount+adj[1],rec);
                    // }
                }
            }
            // vis[src]=true;
            // rec[src]=false;
        }
}
