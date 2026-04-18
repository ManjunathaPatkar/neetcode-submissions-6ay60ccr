class Solution {
    int min;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        min =Integer.MAX_VALUE;
        HashMap<Integer,List<int[]>> hm =new HashMap<>();
        for(int[] flight:flights){
            hm.putIfAbsent(flight[0],new ArrayList<>());
            hm.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        dfs(hm,src,dst,k,0);
        return min==Integer.MAX_VALUE?-1:min;
    }

    private void dfs(HashMap<Integer,List<int[]>> hm, int src, int dst,
        int k, int curCount){
            if(src==dst && k>=-1){
                min = Math.min(min,curCount);
            }
            if(k<-1 || curCount>min){
                return;
            }
            if(hm.containsKey(src)){
                for(int[] adj:hm.get(src)){
                    dfs(hm,adj[0],dst,k-1,curCount+adj[1]);
                }
            }
        }
}
