/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/

public class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        
        int[] sum=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0) sum[j]=grid[0][0];
                else sum[j]=grid[i][j]+Math.min((i>0?sum[j]:Integer.MAX_VALUE),(j>0?sum[j-1]:Integer.MAX_VALUE));
            }
        }
        return sum[n-1];
    }
}
