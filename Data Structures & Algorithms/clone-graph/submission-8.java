/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        HashMap<Node,Node> hm = new HashMap<>();
        Queue<Node> q =new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        q.offer(node);
        boolean isVisited = false;
        while(!q.isEmpty()){
            Node popped = q.poll();
            if(!hm.containsKey(popped)){
                hm.put(popped,new Node(popped.val));
            }
            Node copy = hm.get(popped);
            
            for(Node neighbor: popped.neighbors){
                if(!hm.containsKey(neighbor)){
                    hm.put(neighbor,new Node(neighbor.val));
                }
                else{
                    isVisited = true;
                }
                Node copyN = hm.get(neighbor);
                if(!copy.neighbors.contains(copyN)){
                    copy.neighbors.add(copyN);
                }
                if(!isVisited){
                    q.offer(neighbor);
                }
                isVisited = false;
            }
            visited.add(popped);
        }
        return hm.get(node);
    }
}