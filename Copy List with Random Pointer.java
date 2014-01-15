/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 
 /*
 这个题的问题在于, copy一个节点的时候, 它指向其他节点的指针没有地方可以指,原链表不存在. 当然可以先复制一份链表,不带random,再用指针多次跑来确定random. 带时间复杂度很高. 或者用map来保存到新节点的映射,需要时间和空间复杂度均为O(n)
 
 所以要复制一份, 这样random指向的时候, 指向原节点的next就可以了. O(n)即可, 无需额外空间.
 */
 
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
       if(head==null) return null;
        
// copy each node, and put it to its next; the copy ones do not have random pointer. 
        RandomListNode h=head; // h is a reference, so I can change the reference again in the following
        while(h!=null){
            RandomListNode newNode = new RandomListNode (h.label);  
            RandomListNode temp=h.next;
            h.next=newNode;
            newNode.next=temp;      
            h=h.next.next;
        }
        // assign random
        h=head;
        while(h!=null){
            if(h.random!=null){
                h.next.random=h.random.next;
            }
            h=h.next.next;
        }
        // return the copy, the orignial list should also be changed back
        //break list into two
        h=head;
        RandomListNode res=head.next;
        while(h!=null){
            RandomListNode temp2=h.next;
            h.next=temp2.next;
            if(temp2.next!=null){//这里才是收尾条件,时刻要记住检查赋.next.next的时候,到底存不存在
            temp2.next=temp2.next.next;
            }
            h=h.next;
        }
        return res;
    }
}
