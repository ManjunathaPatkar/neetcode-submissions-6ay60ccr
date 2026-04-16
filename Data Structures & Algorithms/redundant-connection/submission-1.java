class Solution {
    int cycleStart;
    Set<Integer> cycle;
    public int[] findRedundantConnection(int[][] edges) {
        int n =edges.length;
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] vis = new boolean[n+1];
        cycleStart = -1;
        cycle= new HashSet<>();
        dfs(graph,1,-1,vis);
        for(int i=edges.length-1;i>=0;i--){
            if(cycle.contains(edges[i][0]) && cycle.contains(edges[i][1])){
                return edges[i];
            }
        }
        return new int[]{0,0};
    }

    private void dfs(List<Integer>[] graph,int cur, int par,boolean[] vis){
        if(vis[cur]){
            cycleStart =cur;
            return;
        }
        vis[cur]=true;
        for(int adj: graph[cur]){
            if(adj==par){
                continue;
            }
            if (cycle.isEmpty()) {
                dfs(graph, adj, cur, vis);
            }

            if (cycleStart != -1) {
                cycle.add(cur);
            }

            if (cur == cycleStart) {
                cycleStart = -1;
                return;
            }
        }
    }
}



