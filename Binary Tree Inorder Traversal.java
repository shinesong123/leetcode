/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

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
 
 // Time: O(n); Space: O(logn)
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stk=new Stack<TreeNode>();
        // better to have a copy of reference to root
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(root==null) return res;
        
        TreeNode cur=root;
        while(cur!=null||!stk.isEmpty()){
            if(cur!=null){
                stk.push(cur);
                cur=cur.left;
            }else{
                cur=stk.pop();
                res.add(cur.val);
                cur=cur.right;
            }
        }
        return res;
    }
}
