/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7]
  [9,20],
  [3],
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
 
 // 只需要reverse I即可
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
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
        for(int i = res.size()-1; i >= 0; i--){
            reverseRes.add(res.get(i));
        }
        
        return reverseRes;
    }
}
