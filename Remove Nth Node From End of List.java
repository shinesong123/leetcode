/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
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
 //考虑头结点被删的情况
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode p1=head;
    ListNode p2=head;
    for (int i=0; i<n; i++){
        p2=p2.next;
    }
    if(p2==null) return p1.next;
    while(p2.next!=null){
        p1=p1.next;
        p2=p2.next;
    }
    p1.next=p1.next.next;
    return head; 
    }
}
