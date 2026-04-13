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
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode list:lists){
            while(list!=null){
                pq.add(list.val);
                list= list.next;
            }
        }
        ListNode res;
        ListNode cur = new ListNode(0);
        res= cur;
        while(!pq.isEmpty()){
            ListNode node = new ListNode(pq.remove());
            cur.next= node;
            cur =cur.next;
        }
        return res.next;
    }
}
