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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }
        ListNode cur = head, prev = null, next = head.next;
        while(cur.next!=null){
            cur.next = prev;
            prev = cur;
            cur =next;
            next = next.next;
        }
        cur.next = prev;
        prev = cur;
        return prev;
    }
}


// 0->1->2->3
// c  n