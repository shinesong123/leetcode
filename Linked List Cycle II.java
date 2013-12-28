/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Follow up:
 * Can you solve it without using extra space?
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
 //举一个例子开始推,发现相遇后永远在一点相遇,从该点开始走,与从头结点开始走的相遇点就是结点
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
          fast=fast.next.next;
          slow=slow.next;
          if(fast==slow) {
              while(head!=slow){
                  head=head.next;
                  slow=slow.next;
              }
              return head;
        }
        }
        return null;
    }
}
