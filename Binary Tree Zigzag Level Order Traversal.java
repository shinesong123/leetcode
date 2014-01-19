/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
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
public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        if(root==null) return res;
        
        ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
        cur.add(root);
        ArrayList<Integer> a=new ArrayList<Integer>();
        a.add(root.val);
        res.add(a);
        while(cur.size()>0){
             ArrayList<TreeNode> last = cur;
             cur = new ArrayList<TreeNode>(); 
             ArrayList<Integer> level=new ArrayList<Integer>();
             for(TreeNode t: last){
                 if(t.left!=null){
                     cur.add(t.left);
                     level.add(t.left.val);
                 } 
                 if(t.right!=null){
                     cur.add(t.right);
                     level.add(t.right.val);
                 }
             }
             if(level.size()>0) res.add(level);
        }
        
        ArrayList<ArrayList<Integer>>  reverseRes = new ArrayList<ArrayList<Integer>> ();
        for(int i=0; i<res.size(); i++){
            if(i%2==1){
                Collections.reverse(res.get(i));
                reverseRes.add(res.get(i));
            } 
            else reverseRes.add(res.get(i));
        }
        return reverseRes;
    }
}
