/*
Sort a linked list in O(n log n) time using constant space complexity.
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

// 思想就是二分, 然后merge, merge的跟merge two sorted lists以及merge k sorted lists一模一样
public class Solution {
    public ListNode sortList(ListNode head) {
       if (head==null||head.next==null) return head;
       ListNode fast = head;
       ListNode slow = head;
       while (fast.next != null && fast.next.next != null) {// notice here
            fast = fast.next.next;
            slow = slow.next;
       }
       fast = slow.next;
       slow.next = null;
       slow = sortList(head);
       fast = sortList(fast);
       return merge(slow, fast);
    }
    
     private ListNode merge(ListNode l1, ListNode l2) {
        ListNode cur=new ListNode(-1);
        ListNode copy=cur;
        if(l1==null) return l2;
        if(l2==null) return l1;
       
       while(l1!=null & l2!=null){
        if(l1.val>l2.val){
            cur.next=l2;
            cur=cur.next;
            l2=l2.next;
        }else{
            cur.next=l1;
            cur=cur.next;
            l1=l1.next;
        }   
       }
        
        if(l1==null) cur.next=l2;
        if(l2==null) cur.next=l1;
       
        return copy.next;
    }
}
