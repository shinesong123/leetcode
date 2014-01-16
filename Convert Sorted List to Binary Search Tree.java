/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


//数组和LinkList的区别在于, 不能get element n in O(1) time, 按照array那个题的方法,我们需要O(nlogn)的时间复杂度.这里我们需要保持O(n)的复杂度
 
//一个办法是新开数组, 把linklist存到数组里. 空间复杂度额外多了O(n)
 
//另一个办法是照着list的顺序来建tree, 先建左边的, 再建中间的,再建右边的,其实就是preorder traverse. 


//特别要注意, 传参时不要传head, 会改变. 让head在外面

//each time you are stucked with the top-down approach, give bottom-up a try. 

public class Solution {
        ListNode copy;
    public TreeNode sortedListToBST(ListNode head) {
        copy=head;
        if(head==null) return null;
        int n=0; 
        ListNode h=head;
        while(h!=null){
            n++;
            h=h.next;
        }
        return toBST(0, n-1);
    }
    
    private TreeNode toBST(int start, int end ){
        
        if(start>end) return null;
        int mid=start+(end-start)/2;
        TreeNode left=toBST(start, mid-1);
        TreeNode root=new TreeNode(copy.val);
        root.left=left;
        copy=copy.next;
        root.right=toBST(mid+1, end);
        return root;
        
    }
}
