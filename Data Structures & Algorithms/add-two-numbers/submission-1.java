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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur = null;
        ListNode res=cur;
        int sum =0, toAdd =0, carry =0;
        while(l1!=null && l2!=null){
            sum = l1.val +l2.val+carry;
            toAdd = sum%10;
            carry = sum/10;
            if(cur == null){
                cur = new ListNode(toAdd);
                res= cur;
            }else{
                cur.next = new ListNode(toAdd);
                cur = cur.next;
            }
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            sum = l1.val +carry;
            toAdd = sum%10;
            carry = sum/10;
            if(cur == null){
                cur = new ListNode(toAdd);
                res= cur;
            }else{
                cur.next = new ListNode(toAdd);
                cur = cur.next;
            }
            l1=l1.next;
        }
        while(l2!=null){
            sum = l2.val+carry;
            toAdd = sum%10;
            carry = sum/10;
            if(cur == null){
                cur = new ListNode(toAdd);
                res= cur;
            }else{
                cur.next = new ListNode(toAdd);
                cur = cur.next;
            }
            l2=l2.next;
        }
        if(carry!=0){
            cur.next = new ListNode(carry);
            cur = cur.next;
        }
        return res;
    }
}
