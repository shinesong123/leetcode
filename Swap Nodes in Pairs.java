/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null|| head.next==null) return head;
       ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode slow= dummy, fast=head;
        
        while(fast!=null && fast.next!=null){
            ListNode temp=fast.next.next;
            slow.next=fast.next;
            fast.next=temp;
            slow.next.next=fast;
            
            slow=fast;
            fast=fast.next;
        }
        
        return dummy.next;
}
}
