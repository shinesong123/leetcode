/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
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

cur是栈顶元素
用pre来跟踪:
1.如果pre是cur的父亲, 从上往下, 压栈cur的左儿子, if null, 压栈右儿子, if null, 打印cur, pop
2.如果pre是cur的左儿子, 从下往上,压栈cur的右儿子,if null,打印cur, pop(重点)
3.如果pre是cur的右儿子, 从下往上, 打印cur, pop


另一种方法是用两个栈, 在一个栈里,先序遍历的方法, 但是先压左,再压右;然后用另一个栈把它倒过来. 
原理就是先序遍历(略改)反过来就是后序遍历!!!!!后序可以像先序一样,顺序都排好在一个栈里, 直接打印就好了. 
*/
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res= new ArrayList<Integer>();
        if(root==null) return res;
        Stack<TreeNode> stk=new Stack<TreeNode>();
        stk.push(root);
        TreeNode pre=null;
        while(!stk.empty()){
            TreeNode cur=stk.peek();
            if(pre==null||pre.left==cur || pre.right==cur){//这一步pre==null不能省, 重点就在这
                if(cur.left!=null) stk.push(cur.left);
                 else if(cur.right!=null) stk.push(cur.right);
                }
                 else if(cur.left==pre){
                if(cur.right!=null) stk.push(cur.right);
                }
                else{
                res.add(cur.val);
                stk.pop();//这一步是合并了上面两种情况的else, 以及这一步的cur.right==pre
            }
            pre=cur;
        }
        return res;
    }
}


public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res= new ArrayList<Integer>();
        if(root==null) return res;
        Stack<TreeNode> stk1=new Stack<TreeNode>();
        Stack<TreeNode> stk2=new Stack<TreeNode>();
        stk1.push(root);
        while(!stk1.empty()){
            TreeNode cur=stk1.pop();
            stk2.push(cur);
            if(cur.left!=null) stk1.push(cur.left);
            if(cur.right!=null) stk1.push(cur.right);
        }
        while(!stk2.empty()){
            res.add(stk2.pop().val);
        }
          
        return res;
    }
}

