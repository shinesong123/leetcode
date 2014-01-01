/*
Sort a linked list using insertion sort.
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
 //remember: a dummy node
 //这个题做的真不容易啊
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        dummy.next=head;
        ListNode cur=head.next;
        while(cur!=null){
            if(head.val>cur.val){
            ListNode insertPlace=findInsertPlace(dummy,cur);
            head.next=cur.next;
            ListNode temp=insertPlace.next;
            insertPlace.next=cur;
            cur.next=temp;
            cur=head.next;
            }else{
                head=head.next;
                cur=cur.next;
            }
        }
        return dummy.next;
    }
    
     public ListNode findInsertPlace(ListNode h1, ListNode h2){
         //the return should be h1.pre, not h1
         ListNode h1pre=h1;
            while(h1!=null && h1.val<=h2.val){
                    h1pre=h1;
                    h1=h1.next;
                }
            return h1pre;     
            }
}
