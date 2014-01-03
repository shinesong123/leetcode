/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
*/

/*
Method1: O(n)
public class Solution {
    public boolean search(int[] A, int target) {
        for(int i=0; i<A.length; i++){
            if(A[i]==target) return true;
        }
        return false;
    }
}
*/

// worst case: O(n)-- linear search
public class Solution {
    public boolean search(int[] A, int target) {
        int head=0;
        int tail=A.length-1;
        
        while(head<=tail){
            int mid=(head+tail)/2;
            if(target==A[mid]) return true;
            if(A[mid]<A[tail]){
                if((target>A[mid] && target<=A[tail])) head=mid+1;
                else tail=mid-1;
            }else if(A[mid]>A[tail]){
                if((target<A[mid] && target>A[tail])) tail=mid-1;
                else head=mid+1;
            }else{// 如果有重复,无法判断在左边还是右边,tail-1, 重新循环
                tail--;
            }
        }
        return false;
    }
}
