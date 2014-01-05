/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/

public class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0; i<matrix.length;i++){
            for(int j=0; j<matrix[0].length-i-1;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-j-1][n-i-1];
                matrix[n-j-1][n-i-1]=temp;
            }
        }
        
        for(int i=0; i<matrix.length/2;i++){
            for(int j=0 ; j<matrix[0].length; j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-1-i][j];
                matrix[n-1-i][j]=temp;
            }
        }
    }
}

