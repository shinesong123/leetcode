/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
confused what "{1,#,2,3}" means? 
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
 
// recursion, MUST handle null && base cases
 
/*
Method 2: Do in-order traverse
print left tree, print node.val, print right tree, check whether it is increasing.
*/

// Build a tree from top to bottom: topest has minimum limitation, lower, more restriction. 
// for this question, no equal
public class Solution {
    public boolean isValidBST(TreeNode root) {
       return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }  
    private boolean isValidBST(TreeNode root, int min, int max){
     
        if(root==null) return true;
        if(root.val<=min || root.val>=max) return false;
        if(!isValidBST(root.left, min, root.val) || !isValidBST(root.right, root.val, max)) return false; 
        return true;
    }
    }
