/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
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
 
 //use stack to store TreeNode: push mid, right, left; pop peep
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
      ArrayList<Integer> result=new ArrayList<Integer>();
      Stack<TreeNode> stack=new Stack<TreeNode>();
      if(root==null) return result;
      stack.push(root);
      while(!stack.isEmpty()){
          TreeNode peek=stack.peek();
          result.add(peek.val);
          stack.pop();
          if(peek.right!=null) stack.push(peek.right);
          if(peek.left!=null) stack.push(peek.left);
      }
      return result;
    }
}
