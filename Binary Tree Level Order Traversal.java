/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
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
每下一层利用取上一层的左右节点即可.
即第n个节点利用第n-1个节点的结果

*/

public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        if(root==null) return res;
        
        ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
        cur.add(root);
        ArrayList<Integer> a=new ArrayList<Integer>();
        a.add(root.val);
        res.add(a);
        while(cur.size()>0){
             ArrayList<TreeNode> last = cur;
             cur = new ArrayList<TreeNode>(); // cur清空,填新的
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
        return res;
    }
}
