/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

// should change classic binary search to find the lower and upper bound
public class Solution {
    public int[] searchRange(int[] A, int target) {
        int start1=0;
        int end1=A.length-1;
        
        int[] result= {-1,-1};
        
        //find lower bound
        while(start1<end1){
            int mid1=(start1+end1)/2;
            if(target<=A[mid1]) end1=mid1;
            else start1=mid1+1;
        }
        //check whether there exists the target
        if (A[start1]!=target) return result;
        result[0]=start1;
        
        // fint the upper bound
        // set end out of range, find the most recent large one to target
        int start2=0;
        int end2=A.length;
        
        
        while(start2<end2){
            int mid2=(start2+end2)/2;
            if(target>=A[mid2]) start2=mid2+1;
            else end2=mid2;
        }
        result[1]=end2-1;
        return result;                             
    }
}
