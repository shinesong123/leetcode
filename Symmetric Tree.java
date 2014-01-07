/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
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
 
 /*
 Method1: recursion
 isSymmetric(left.left, right.right); 
 isSymmetric(left.right, right.left)
 leftnode.val==rightnode.val
 
 Method2:iteratively, preorder traverse
 */
 
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSymmetric(root.left, root.right);
    }
    
    private boolean isSymmetric(TreeNode left, TreeNode right){
        if(left==null && right == null) return true;
        else if(left==null || right==null) return false;
        if(left.val==right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left)) return true; 
        else return false;
    }
    
    
}
