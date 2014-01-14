/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/

// 不能开空间,还是需要一行一列来记录结果,只好先算好第一行和第一列,然后用第一行和第一列来计算结果
public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean column=false;
        boolean row=false;
        for(int i=0;i<matrix.length; i++){
            if(matrix[i][0]==0){
            column=true; 
            break;
            }
        }
        
        for(int i=0;i<matrix[0].length; i++){
            if(matrix[0][i]==0) {// 这里, 括号不要偷懒不写, 括号里面是两个句子, 不括起来,第二个句子就会无条件执行!!!!!!!!!! 一定要注意
            row=true; 
            break;
            }
        }
        
        for (int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        
        // start from 1; do not change first row & column
       for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        
        if(column){
            for(int i=0; i<matrix.length;i++) matrix[i][0]=0;
        }
        if(row){
            for(int i=0; i<matrix[0].length;i++) matrix[0][i]=0;
        }
        
        
    }
}
