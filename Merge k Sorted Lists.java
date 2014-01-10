/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
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
 
 //Same as merge 2 sorted lists, just do it one by one
 //ArrayList has iterator, do not write (i=0;i<n)!!!!!!
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
       ListNode head = null;
       for (ListNode node : lists)
            head = mergeTwoLists(head, node);
        return head;
    }
    
     private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
