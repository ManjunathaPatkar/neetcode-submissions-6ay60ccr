/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0) return null;

        PriorityQueue<ListNode> q= new PriorityQueue<ListNode>(lists.length, (a,b)-> a.val-b.val);

        ListNode res=new ListNode(0);
        ListNode cur=res;
        
        for(ListNode node:lists){
            if(node!=null){
                q.offer(node);
            }
        }

        while(!q.isEmpty()){
            cur.next=q.poll();
            cur=cur.next;
            if(cur.next!=null){
                q.offer(cur.next);
            }
        }
        return res.next;
    }
}