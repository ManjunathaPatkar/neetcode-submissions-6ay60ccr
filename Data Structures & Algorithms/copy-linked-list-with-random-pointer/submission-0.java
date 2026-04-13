/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> nodeMap = new HashMap<>();
        Node cur=head;
        while(cur!=null){
            Node n = new Node(cur.val);
            nodeMap.put(cur,n);
            cur = cur.next;
        }
        cur =head;
        while(cur!=null){
            Node n =nodeMap.get(cur);
            Node next = nodeMap.get(cur.next);
            Node random = nodeMap.get(cur.random);
            n.next = next;
            n.random = random;
            cur = cur.next;
        }
        return nodeMap.get(head);
    }
}
