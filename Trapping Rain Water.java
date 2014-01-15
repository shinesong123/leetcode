/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
*/

/*
方法一:
对于每个柱子,找到其左右两边最高的柱子, 需要新开两个数组来记录, 时间和空间复杂度均为O(n)

方法二: 精妙!
找到最高的柱子, 分开处理左边和右边. 时间O(n), 空间O(1).
对于左边来说, 已经知道它的右边最大了, 只需要左边最大,用peek来记录;
对于右边来说, 已经知道它的左边最大了, 只需要右边最大,用peek来记录;实际也是第二高的思想.

*/

public class Solution {
    public int trap(int[] A) {
        int max=0;
        for(int i=0;i<A.length; i++){
            if(A[i]>A[max]) max=i;
        }
        
        int res=0;
        int peek1=0;
        int peek2=0;
        for(int i=0; i<max; i++){
            if(A[i]>peek1) peek1=A[i];
            res+=peek1-A[i];
        }
        
        for(int i=A.length-1; i>max; i--){
            if(A[i]>peek2) peek2=A[i];
            res+=peek2-A[i];
        }
        return res;
    }
}
