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
    public ListNode reverseKGroup(ListNode head, int k) {
        int n =k;
        ListNode start = new ListNode(0);
        ListNode res = start,prev,next,l,end,cur;
        k--;
        while(head!=null){
            cur = head;
            while(k>0 && head!=null){
                head = head.next;
                k--;
            }
            
            if(head==null){
                start.next = cur;
                break;
            }
            k=n-1;
            end= head;
            l=head.next;
            head.next=null;

            prev= null;
            next= null;
            while(cur!=null){
                next = cur.next;
                cur.next= prev;
                prev= cur;
                cur =next;
            }
        
            start.next = prev;
            while(start.next!=null){
                start=start.next;
            }
            head =l;

        }
        return res.next;
    }
}
