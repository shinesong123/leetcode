/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/

/* 首先，不用跳到那个点, 超过也算, 因为是上限,可以自动选择落在终点

1.dp可解,维护一个dp[]数组即可

2.贪心法: 
跟jump game1一样, 对每个位置i,记录能达到的最远距离max,同时保留一个值来记录步数. last是用step+1步能到达的最远距离. 时间O(n), 空间O(1)
*/

public class Solution {
    public int jump(int[] A) {
        int step=0;
        int max=0;
        int last=0;
        
        for(int i=0;i<A.length;i++){
            if(i>last){
                last=max;
                step++;
            }
            max=Math.max(max, i+A[i]);
        }
        return step;
        
    }
}
