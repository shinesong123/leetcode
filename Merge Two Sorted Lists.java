/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
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
 
 // O(n)
 // if no space limit, never manipulate on original, open a new one !!!!!!!!111
 // don't manipulate on l1, create a new list with a cur pointer, insert from l1 and l2
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
