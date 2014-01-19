/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
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
O(n)空间的解法比较直观，中序遍历一遍以后，重新赋值一遍/发现异常的两个点,交换它们，这个解法可以面向n个元素错位的情况。

还是要做inorder的遍历,这样才能找出错位的点. 要保持一个pre变量来跟踪上一个节点,而不是用堆栈,这样就不用空间,但是时间复杂度高, O(n), 而且是比较大的O(n), 在循环的最后让pre=cur就更新pre了

对每个节点都要单独审查,比较它和它的pre, 对每个节点的左右节点也要单独审查它们和它们的pre, 这样这个节点的使命就完成了
 

第一次发现的肯定是pre有问题, 因为是binary search tree, 应该升序, 第一个出现问题的地方跟pre比较的时候没问题,自己作为pre跟后面比较就出问题了;同理,第二次发现的肯定是cur有问题. 还有可能的情况是只发现一次有问题, 那就是那两个点错了.

Morris中序遍历, 无栈, O(1)空间
*/
 
public class Solution {                                                                                                                                                
    TreeNode pre = null;
    TreeNode first = null;
    TreeNode second = null;
    int num = 0;
    public void recoverTree(TreeNode root) {
        findBadNodes(root);
        swap(first,second);
    }
    
    void findBadNodes(TreeNode cur){
        if(cur ==null || num == 2) return;
        findBadNodes(cur.left);
        if(pre!=null && num == 0 && pre.val > cur.val ){
            first = pre;
            second = cur;
            num = 1;
        }else if(pre!=null && num == 1 && pre.val > cur.val){
            second = cur;
            num = 2;
        }
        pre = cur;
        findBadNodes(cur.right);
    }
    
    void swap(TreeNode first, TreeNode second){
        int val = first.val;
        first.val = second.val;
        second.val = val;
    }
    
    
}
