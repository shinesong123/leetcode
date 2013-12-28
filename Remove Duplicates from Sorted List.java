/**
*Given a sorted linked list, delete all duplicates such that each element appear only once.
*
*For example,
*Given 1->1->2, return 1->2.
*Given 1->1->2->3->3, return 1->2->3.

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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode copy=head;
       while(head!=null && head.next!=null){
       if (head.val==head.next.val){
            head.next=head.next.next;
        }
        else {
            head=head.next;
        }
       }
        return copy;
        
    }
}
