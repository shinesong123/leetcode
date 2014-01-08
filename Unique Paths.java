/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.
*/

// 不能用brute force recursion, time exceeds!
// 为了节省空间,不用开二维数组,开一个一维的,滚动更新
public class Solution {
    public int uniquePaths(int m, int n) {
        if(m<=0||n<=0) return 0;
        int[] result=new int[n];
        result[0]=1;
        
        for(int i=0;i<m;i++){
            for(int j=1; j<n;j++){
                if(i==0) result[j]=1;
                else result[j]=result[j]+result[j-1];//amazing!
            }
        }
        return result[n-1];
    }
}
