/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

// should consider only with one row or one column-- this would happen for the end condition;
// so must write another function and call it. 
// should consider don't add dup corner elements
// m, n should minus 2 after each loop



public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        
        ArrayList<Integer> res=new ArrayList<Integer>();
        int n=matrix.length;
        if(n==0) return res;
        int m=matrix[0].length;
        
        spiral(matrix,m,n,0,res);
        return res;
    }
    
    
    private void spiral(int[][] matrix, int m, int n, int level, ArrayList res){
        if(m==0||n==0) return;
        if(n==1){
            for (int i=0;i<m;i++) res.add(matrix[level][i+level]); return;
        }
        if(m==1){       
            for (int i=0;i<n;i++) res.add(matrix[i+level][level]); return;
        }
        for(int i=0;i<m-1;i++) res.add(matrix[level][i+level]); 
        for(int i=0;i<n-1;i++) res.add(matrix[i+level][m-1+level]); 
        for(int i=m-1;i>0;i--) res.add(matrix[n-1+level][i+level]);
        for(int i=n-1;i>0;i--) res.add(matrix[i+level][level]);
       
            
        spiral(matrix, m-2, n-2, level+1,res);//m-2 maybe 0, maybe 1
    }
    
}

