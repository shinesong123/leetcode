/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
 
 // 构造binary search tree的可能性有很多种,这里选择数组的中点作为root
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if(num.length==0) return null;
        return toBST(num, 0, num.length-1);
    }
    
    private TreeNode toBST(int[] num, int start, int end){
        int mid=(end+start)/2;
        if(start>end) return null; // end condition
        TreeNode root=new TreeNode(num[mid]);
        root.left=toBST(num,start, mid-1 );
        root.right=toBST(num, mid+1, end);
        return root;
    }
}
