/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
 
/*
用[1,..., i-1]建造左树, [i+1, ..., n]建造右数
这种有范围的, 要循环,都需要单独写help函数(int start, int end)
 
generateTree返回的是root列表.
 
最后的结果是一个一个的root, 用多少种排法就有多少个点. 每个点底下是一棵大树.
 
对于一个点来说, 它左子树结果集--里的每一个点都可能是新左节点,右子树结果集--里每一个点都可能是新右节点.
 
这题要重做

就是递归的思想, 没有什么难的, 是树的题, 上来先想递归!


*/
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if(n==0){
            result.add(null);
            return result;
        }
        return generateTree(1,n);
    }
    
    private ArrayList<TreeNode> generateTree(int start, int end){
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if(start>end) {
            res.add(null);
            return res;
        }
        for(int i=start; i<=end; i++){
            ArrayList<TreeNode> left=generateTree(start, i-1);
	        ArrayList<TreeNode> right=generateTree(i+1, end);
	        
	        for(int j=0;j<left.size(); j++){
	            for(int k=0;k<right.size();k++){
	                TreeNode root=new TreeNode(i);
	                root.left=left.get(j);
	                root.right=right.get(k);
	                res.add(root);
	            }
	        }
        }
        return res;
    }
}
