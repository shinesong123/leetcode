/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/


//O(n) 遍历一遍

// sum记录之前subarray的和
// max用来返回最大值
// 当sum>max时,说明发现了更大的subarray序列, 此时更新max

// 对于新出现的一个数,如果之前subarray的sum>0, 考虑加入,判断一下加入后是不是比max大; 如果sum<0, 加入对数本身来说没有任何帮助,只会更小,还不如就自己,或自己带后面的


/*
Use divide and conquer

Any subarray A[i,...,j] is:
1) Entirely in A[low,mid]
2) Entirely in A[mid+1, high]
3) in both

1) and 2) could be do recursively; 
3) is find maximum subarrays crosses midpoint, which is find max A[i,..mid]+max A[mid+1,..,j]

Time: T(n)=2T(n/2)+O(n)=O(nlgn)
*/
public class Solution {
    public int maxSubArray(int[] A) {
        
        int max=Integer.MIN_VALUE;
        int sum=Integer.MIN_VALUE;
        
        
        for(int i=0;i<A.length;i++){
            sum=sum>0?sum+A[i]:A[i];
            max=Math.max(sum, max);
        }
        return max;
    }
}
