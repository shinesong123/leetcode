/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
 /*
 1. partition the list into two
 2. reverse the second half
 3. merge. 
 
 最需要留意的是停止条件,这个解决了,就都解决了.
 Notice: 
 1. use three pointers to revers linked list: cur, post and temp
 2. should handle {} and {1}
 3. should be fast.next!=null && fast.next.next!=null
 */
public class Solution {
    public void reorderList(ListNode head) {
       if(head==null ||head.next==null) return;
       
       ListNode head1=head;
       
       ListNode slow=head, fast=head;
       while(fast.next!=null && fast.next.next!=null){
           slow=slow.next;
           fast=fast.next.next;
       }
       ListNode head2=slow.next;
       slow.next=null;
       head2=reverseList(head2);
       merge(head1, head2);
    }
    
    
    
    private ListNode reverseList(ListNode head){
        ListNode cur=head;
        ListNode post=cur.next;
        cur.next=null;
        while(post!=null){
            ListNode temp=post.next;
            post.next=cur;
            cur=post;
            post=temp;
        }
        return cur;
    }
    
    private ListNode merge(ListNode head1, ListNode head2){
        while(head1!=null && head2!=null){
            ListNode temp1=head1.next;
            ListNode temp2=head2.next;
            head1.next=head2;
            head2.next=temp1;
            head1=temp1;
            head2=temp2;
        }
        return head1;
    }
    
    
}
