/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
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
 
 /*
 没有什么猫腻, 纯跟reverse一样, 重新回顾Reorder List的reverse
 找到m-1那个节点, 开始翻转, 一次挪一个到前面来,总共要翻转n-m次, 
 */
 
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||head.next==null||m==n) return head;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        
        ListNode h=dummy;// 要从dummy开始,因为可能就是从1要开始操作,整个时候h应该是dummy
        int k=1;
        while(k<m){
            h=h.next;
            k++;
        }
        h.next=reverseN(h.next, n-m);
        return dummy.next;
    }
    
    private ListNode reverseN(ListNode head, int n){
        ListNode cur=head;
        ListNode post=cur.next;
        cur.next=null;
       for(int i=0;i<n;i++){
            ListNode temp=post.next;
            post.next=cur;
            cur=post;
            post=temp;
        }
        ListNode c=cur;
        while(c.next!=null){
            c=c.next;
        }
        c.next=post;
        return cur;
    }
}
