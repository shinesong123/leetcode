/*
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
*/

// don't create new array, update from tail
// notice end condition
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int k=m+n-1;
        int i=m-1;
        int j=n-1;
         
        while(k>=0){
            if( j<0||i>=0 && A[i]>B[j]){
                A[k--]=A[i--];
            }else{
                A[k--]=B[j--];
            }
            
        }
        
    }
}
