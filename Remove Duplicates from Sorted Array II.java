/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
*/

// j move forward, should notice the bond; should keep track of pointer i and j
public class Solution {
    public int removeDuplicates(int[] A) {
       if (A.length<=1) return A.length;
        int i=-1,j=0;
        while(j<A.length){
            if(j+1<A.length && A[j]==A[j+1]){
                i++;
                A[i]=A[j];
                j++;
            }
            while(j+1<A.length && A[j]==A[j+1]){//j has been ++, should notice out of bond.
                j++;
            }
            i++;
            A[i]=A[j];
            j++;
        }
        return i+1;
    }
}
