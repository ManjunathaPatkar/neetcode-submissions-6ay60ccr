class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean[] vis = new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(graph,i,vis);
            }
        }
        return count; 
    }
    private void dfs(List<Integer>[] graph,int i,boolean[] vis){
        vis[i]=true;
        for(int adj:graph[i]){
            if(!vis[adj]){
                dfs(graph,adj,vis);
            }
        }
    }
}
