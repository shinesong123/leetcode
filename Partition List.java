/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
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
 
// 链表总是很麻烦的, 不要老是想着在原链表上操作, 尤其是排序, 如果对空间没有要求, 就单独建链表,最后合起来
 
// >=的都放在右边

public class Solution {
    public ListNode partition(ListNode head, int x) {
       ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);
        ListNode lp = left;
        ListNode rp = right;
        
        ListNode h=head; 
        
        while (h != null) {
            if (h.val < x) {
                lp.next = h;
                lp = lp.next;
            } else {
                rp.next = h;
                rp = rp.next;
            }
            h = h.next;
        }
        if(rp.next!=null) rp.next=null;// 最后收尾处理一下, 右边可能带了不该带的, 左边不该带的反正也被右边覆盖了
        
        lp.next = right.next;
        return left.next;
        
    }
}
