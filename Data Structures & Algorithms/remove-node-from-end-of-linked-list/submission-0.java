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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count =0;
        ListNode cur = head, prev =null;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        n = count-n;
        cur =head;
        while(n!=0){
            prev= cur;
            cur= cur.next;
            n--;
        }
        if(prev == null){
            head = cur.next;
        }else{
            prev.next =cur.next;
        }
        return head;
    }
}


