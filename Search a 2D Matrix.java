/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.

*/

//记得利用/ 和%, 非常有用
//二分查找
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int low=0;
        int high=m*n-1;
        while(low<=high){//注意这里是<= , 要考虑最后收尾的情况
            int mid=(low+high)/2;
            if(target==matrix[mid/n][mid%n])return true;
            else if(target<matrix[mid/n][mid%n]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
       
        
    }
}
