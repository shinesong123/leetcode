/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/

/* 
Method 1: two pass
count number of 0s, 1s and 2s (count sort);
fill the array with total number of 0s, 1s and 2s. 
*/

/*
Method 2: one pass
meet 0s, put it in front;
meet 2s, put it in the tail;
meet 1s, leave it there.

initial left=-1; right=length; ++ and -- before manipulate
*/
public class Solution {
    public void sortColors(int[] A) {
        
        int left=-1;
        int right=A.length;
        int i=0;
        
            while(i<right){
                if(A[i]==0){
                    left++;
                    swap(A, left, i);
                    i++;
                }else if(A[i]==2){
                    right--;
                    swap(A,i,right);// here is i, not i++, notice the detail!!
                }else{
                    i++;
                }
            }
    }
        private void swap(int[] A, int i, int j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
        }
}
