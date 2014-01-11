/*
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
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
 

 // Recusion的方法里,当root==null, 要return 0, 而非MIN_VALUE, 会毁了之前的全部路径
 // Math.max(a,b) could only compare two elements!!!!!!!!!!!!!!
 
 // dfs大部分时候就是recursion
 
 /* 举例说明: 同max subarray那题
        D 
       /
      A
     / \
    B   C
    
    从下往上走,对节点A来说, sum=root.val, 四种可能(A,BA, BAC, CA, 选最大的一种), 向上层返回时只返回三种(A,BA,CA)
    
    max记录有史以来最大值; max是大程序的返回值
    
    小程序里面要返回左支+节点/ 右支+节点, 返回单支值,只是因为对于上层来说,并不需要BAC, 如果BAC够大,它会被记在max里;
    返回单支值时要考虑,如果下面的<0, 只返回单节点; >0就带上它们
 */
 
public class Solution {
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;  
        if(root==null) return Integer.MIN_VALUE;
        maxSum(root);
        return max;
    }
    private int maxSum(TreeNode root){
        if(root==null) return 0;
        int left=maxSum(root.left);
        int right=maxSum(root.right);
        int single=Math.max(left+root.val,right+root.val);
        int arc=left+root.val+right;
        int temp1=Math.max(single, arc);
        int temp2=Math.max(temp1, root.val);
        max=Math.max(max, temp2);
        
        
        return Math.max(single, root.val);
    }
    
    
}

