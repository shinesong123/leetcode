/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
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
 // use preorder traverse
 // stack.pop() return peek
public class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode result=null;
        stack.push(root);
        while(!stack.isEmpty()){
           TreeNode pop=stack.pop();
           if(pop.right!=null) stack.push(pop.right);
           if(pop.left!=null) stack.push(pop.left);
           // need to handle the first of result
           if(result!=null){
           result.left=null;
           result.right=pop;
           }
           // here: should not be result=result.right;
           result=pop;
           
        }
        
    }
}
