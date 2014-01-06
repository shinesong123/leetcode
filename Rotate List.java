/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL
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
    public ListNode rotateRight(ListNode head, int n) {
        if(head==null || head.next==null) return head;
        
        int count=0;
        ListNode head1=head;
        
        while(head1!=null){
            head1=head1.next;
            count++;
        }
        
        if(n>=count) n=n%count; 
        if(n==0) return head;
        
        ListNode copy=head;
        ListNode slow=head;
        ListNode fast=head;
        
        while (n>0){
            fast=fast.next;
            n--;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        ListNode result=slow.next;
        fast.next=copy;
        slow.next=null;
        return result;
        
    }
}
