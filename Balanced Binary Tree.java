/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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
 
 //一次过
 
public class Solution {
    public boolean isBalanced(TreeNode root) {
       if(root==null) return true;
       if(isBalanced(root.left)&& isBalanced(root.right) && Math.abs(depth(root.left)-depth(root.right))<=1) return true;
       else return false;
        
    }
    
    private int depth(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(depth(root.left), depth(root.right));
    }
}
