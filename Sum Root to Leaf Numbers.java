/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
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
 
 //DFS,对每个节点,要输入它上一层的值,在这一层*10, 这一层返回left+right. 
 //DFS一般就是递归, 都要额外写一个help函数
 
public class Solution {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }
    
    private int sum(TreeNode root, int pre){
        if(root==null) return 0;
        pre=pre*10+root.val;
        if(root.left==null && root.right==null) return pre;
        return sum(root.left, pre)+sum(root.right,pre);
        
    }
    
}
