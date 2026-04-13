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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        int n =0;
        ListNode l2=head, l1=head, l1End=null;
        while(l2!=null){
            n++;
            l2 =l2.next;
        }
        n = n/2;
        l2=head;
        l1=head;
        while(n!=0){
            n--;
            l1End= l2;
            l2=l2.next;
        }
        l1End.next=null;
        ListNode cur = l2, prev=null, next=l2.next;
        while(cur.next!=null){
            cur.next = prev;
            prev= cur;
            cur=next;
            next=next.next;
        }
        cur.next = prev;
        prev= cur;
        l2=prev;
        ListNode res= l1;
        cur =null;
        res= cur;
        // System.out.println("l1");
        // while(l1!=null){
        //     System.out.println(l1.val);
        //     l1=l1.next;
        // }
        // System.out.println("l2");
        // while(l2!=null){
        //     System.out.println(l2.val);
        //     l2=l2.next;
        // }
        while(l1!=null && l2!=null){
            if(cur==null){
                cur =l1;
                l1=l1.next;
                cur.next =l2;
                l2=l2.next;
                cur=cur.next;
                continue;
            }
            cur.next= l1;
            l1=l1.next;
            cur=cur.next;
            cur.next =l2;
            l2=l2.next;
            cur=cur.next;
        }
        while(l1!=null ){
            cur.next= l1;
            l1=l1.next;
            cur=cur.next;
        }
        while(l2!=null ){
            cur.next= l2;
            l2=l2.next;
            cur=cur.next;
        }
        head= res;
    }
}
