/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
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
 
/*
深度搜索即可，用一个变量记录当前路径，一旦获得满足条件的路径，记录到最终结果中.

不管对不对,temp里都要加进那个节点,然后进行下面的dfs,但是有可能这条路径不成功, 那么当程序都走完(左右都试过)还不成功, 说明这个节点无论如何都不行,就要退一步, 把刚加进去的值给删掉, 只删它一个. 再去走别的路, temp是反复重复利用的, 它里面除了root一直在里面, 其他值基本上是一直在被删的状态中. 这个题就是不停的去试, 试了不行就删掉.

一个很重要的问题, 把temp加到res里面, temp就没有了, 不能进行下面的了. 所以加进res的时候要复制一个temp加进去, 让temp保持原样.

ArrayList-- path.remove(int i) remove element in index i

*/
public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp=new ArrayList<Integer>();// must have path in helper, they may not add to result, but recursion need to have a place to store result. 
        pathSum(root, sum, temp, res);
        return res;
    }
    
    private void pathSum(TreeNode root, int sum, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res){
       
        if(root==null) return;
        temp.add(root.val);
        if(root.left==null && root.right==null && root.val==sum){
            ArrayList<Integer> path = new ArrayList<Integer>(temp);
            res.add(path);
        }else{
            pathSum(root.left, sum-root.val, temp, res);
            pathSum(root.right, sum-root.val, temp, res);
        }
        temp.remove(temp.size()-1);
            
    }
    
}
