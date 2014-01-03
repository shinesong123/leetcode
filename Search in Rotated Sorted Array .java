/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

/*
Method1: O(n)
public class Solution {
    public int search(int[] A, int target) {
        int n=-1;
        for(int i=0; i<A.length; i++){
            n++;
            if(A[i]==target) return n;
        }
        return -1;
    }
}

Method2: binary search --O(logn)
根据是在0--那一段,还是--tail那一段来判断,因为一定有一段是升序
*/


public class Solution {
    public int search(int[] A, int target) {
        int head=0;
        int tail=A.length-1;
        
        while(head<=tail){
            int mid=(head+tail)/2;
            if(target==A[mid]) return mid;
            if(A[mid]<A[tail]){
                if((target>A[mid] && target<=A[tail])) head=mid+1;
                else tail=mid-1;
            }else{
                if((target<A[mid] && target>A[tail])) tail=mid-1;
                else head=mid+1;
            }
        }
        return -1;
        
    }
}
