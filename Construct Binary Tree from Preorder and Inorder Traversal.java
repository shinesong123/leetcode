/*
Given preorder and inorder traversal of a tree, construct the binary tree.

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
 Inorder, 根中间; Preorder, 根优先

           5
         /   \
        4     6
       / \   / \
      3   2 7   8
     / \         \
    1   9         10
    
Preorder: 5, 4, 3, 1, 9, 2, 6, 7, 8, 10
Inorder:  1, 3, 9, 4, 2, 5, 7, 6, 8, 10

在Inorder里找到了根的位置,就找到了后面循环时的起始和终止Index
结束条件是s1>e1或者s2>e2, 跑一个例子就知道了;

这个题要重做;

*/

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int m=preorder.length-1;
        int n=inorder.length-1;
        if(m==-1) return null;
        
        return build(preorder, 0,m, inorder,0,n);
    }
    
    private TreeNode build(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2){
        if(s2>e2) return null;
        
        int index=-1;
        for(int i=s2; i<=e2;i++){// notice the search range here
            if(preorder[s1]==inorder[i]){
                index=i;
                break;
            } 
        }
        int len=index-s2;// notice here, need to do again
        
        TreeNode root=new TreeNode(preorder[s1]);
        root.left=build(preorder, s1+1, s1+len, inorder, s2, index-1);
        root.right=build(preorder, s1+len+1, e1, inorder, index+1, e2);// notice start and end for preorder, need to see the example
        
        return root; 
        
        
    }
    
}
