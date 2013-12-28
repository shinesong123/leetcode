/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
         int sum=0;
        ListNode l3=new ListNode(0);
        ListNode head=l3;
        while (l1!=null || l2!=null){
            sum=carry;
            if(l1!=null){
                sum=sum+l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum=sum+l2.val;
                l2=l2.next;
            }
            if(sum>=10){
                carry=1;
                sum=sum-10;
            }else{
                carry=0;
            }
            l3.next=new ListNode(sum);
            l3=l3.next;
            
        }
        if(carry==1){
            l3.next=new ListNode(carry);
        }
        return head.next;
        
        
        
    }
}
