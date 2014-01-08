/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
*/

// if there is a 1, the path there turn to be 0
// the first row and first column is no longer always 1 !!
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        
        if(m<=0||n<=0||obstacleGrid[0][0]==1) return 0;
        int[] result=new int[n];
       
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==0){
                    if(i==0 && j==0) result[j]=1;
                    else result[j]=result[j]+(j>0?result[j-1]:0);
                }else result[j]=0;
                
            }
        }
        
        return result[n-1];
        
    }
}
