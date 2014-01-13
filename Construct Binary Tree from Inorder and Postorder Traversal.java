/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
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
 后序的最后一个元素是root, 在中序中找到这个元素; 该元素前为左支数目,后为右支数目
 根据此可在后续中找到左支和右支的root;
 以此递归.
 
 前提:保证无重复

*/
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         int m = inorder.length-1;
         int n = postorder.length-1;
         return buildTree(inorder, 0, m, postorder, 0, n);
    }
        
    private TreeNode buildTree(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd){
         if(postStart>postEnd) return null;
         int index=-1;
         for(int i=inStart; i<=inEnd; i++){
             if(in[i]==post[postEnd]){
                 index=i;
                 break;
             }
         }
      
        int len=index-inStart;
        TreeNode root = new TreeNode(post[postEnd]);
        root.left = buildTree(in, inStart, index-1, post, postStart, postStart+len-1); // 注意len要-1, 仔细一点
        root.right = buildTree(in, index+1, inEnd, post, postStart+len, postEnd-1);
        
        return root;
    }
}
