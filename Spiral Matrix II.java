/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

// must always remember end condition !! odd ann even number is different !!
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];
        if(n<=0) return res;
        int start=1;
        
        for(int level=0;level<=(n-1)/2;level++){
            if(level==n-1-level) res[level][level]=n*n;            //end condition for odd number
            for(int i=level; i<n-1-level;i++) res[level][i]=start++;
            for(int i=level; i<n-1-level;i++) res[i][n-1-level]=start++;
            for(int i=n-1-level;i>level;i--) res[n-1-level][i]=start++;
            for(int i=n-1-level;i>level;i--) res[i][level]=start++;
            
        }
        
        return res;
    }
    
}
