/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 
/*
If we are allowed to use additional memory, then we could just maintain two queues and do level-order traversal over the tree (i.e. level by level, each queue store all the nodes in a single level in turn). 

Yes, the memory we need is already there and given! The LinkTreeNode contains the next pointer, the reason we need to store all the elements into a queue using additional memory previously is that we need all of them to get all the nodes in next level.

We can access all the information as long as we have the first node in that level. Because we make the list, so every level is a linked list, once we get the head, we get the whole thing.
*/
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null||root.left==null && root.right==null) return;
        if(root.left!=null){
            if(root.right!=null) root.left.next=root.right;
            else root.left.next=getNextNodeNextLevel(root);
        }
        if(root.right!=null) root.right.next=getNextNodeNextLevel(root);
       
        connect(root.right); //顺序很重要,从最右边开始连, 右边的一串连好了再连左边的. 这样才可能通过递归连成整条链. 每条链不是一条连好再连下一条,是从左到右部分部分连起来的
        connect(root.left);
    }
    
    private TreeLinkNode getNextNodeNextLevel(TreeLinkNode t){
        while(t.next!=null){
           t=t.next;
           if(t.left!=null) return t.left;
           if(t.right!=null) return t.right;
        }
        return null;
    }
    
    
}
