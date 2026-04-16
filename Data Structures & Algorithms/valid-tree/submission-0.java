class Solution {
    public boolean validTree(int n, int[][] edges) {
        boolean[] vis = new boolean[n];
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            graph[edge[1]].add(edge[0]);
            graph[edge[0]].add(edge[1]);
        }
        if(!dfs(graph,0,-1,vis)){
            return false;
        }
        System.out.println("DFS done");
        for(int i=0;i<n;i++){
            if(!vis[i]){
                System.out.println("Dont visit "+i);
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<Integer>[] graph,int i,int parent, boolean[] vis){
        vis[i]=true;
        for(int adj:graph[i]){
            if(!vis[adj]){
                if(!dfs(graph,adj,i,vis)){
                    return false;
                }
            }
            else if(adj!=parent){
                return false;
            }
        }
        return true;
    }
}
