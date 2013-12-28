/**
*Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

*For example,
*Given 1->2->3->3->4->4->5, return 1->2->5.
*Given 1->1->1->2->3, return 2->3.
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
 
 //add a dummy node 
 //add a flag mark dup
 //use two pointers, one is update; one is delete, detect whether duplicate;
 //dummy牵起一整串,update跟着delete走判断有效还是无效,用来更新dummy
public class Solution {
    public ListNode deleteDuplicates(ListNode head) { 
    ListNode dummy=new ListNode(0);
    dummy.next=head;
    ListNode update=dummy;
    ListNode delete=head;
    
    while (delete!=null && delete.next!=null){
        Boolean dup=false;
        //注意这里要多加一个条件,不然编译通不过,要注意结尾条件
        while (delete.next!=null && (delete.val==delete.next.val)){
            delete=delete.next;
            dup=true;
        }
        if(dup){
            update.next=delete.next;//改变dummy后面的链接,跳跃
        }else{
            update=delete;//不改变dummy 后面的链接;往前挪动,不跳跃
        }
        delete=delete.next;
        
    }
    return dummy.next;
    
    }
}
