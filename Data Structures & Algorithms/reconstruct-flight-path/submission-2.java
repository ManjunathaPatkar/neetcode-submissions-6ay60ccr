class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res=new LinkedList<>();
        HashMap<String,PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> ticket:tickets){
            if(!graph.containsKey(ticket.get(0))){
                graph.put(ticket.get(0),new PriorityQueue<>());
            }
            graph.get(ticket.get(0)).offer(ticket.get(1));
        }
        dfs(graph,"JFK",res);
        return res;
    }
    private void dfs(
        HashMap<String,PriorityQueue<String>> graph, String cur, List<String> res){
            if(graph.containsKey(cur)){
                while(!graph.get(cur).isEmpty()){
                        dfs(graph,graph.get(cur).poll(),res);
                }
            }
            res.add(0,cur);
        }
}
