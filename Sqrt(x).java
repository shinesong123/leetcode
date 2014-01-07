/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/

// binary search: use x/mid==mid; use mid*mid might overflow;

public class Solution {
    public int sqrt(int x) {
        if(x<=0)return 0;
        int low=1;
        int high=x;
        int mid;
        while(low<=high){
            mid=(low+high)/2;
            if(x/mid>mid) low=mid+1;
            else if (x/mid<mid) high=mid-1;
            else return mid;
        }
        mid=(low+high)/2;
        return mid;
        
    }
}
