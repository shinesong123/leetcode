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

2.贪心法: 时间O(n), 空间O(1)
last记录的是上上上上上次能到的最大位置, 及通过最小步数能够到达的最大点.
当i的值超出以前的最大范围, 说明之前一跳能产生的每一步都考虑过了, 必须再跳才能继续. 所以步数+1. 并且把last更新为此时的最大范围.             

max仍然保持的是在每一点可能到达的最大值. step是在无法继续的时候+1, 让游戏继续. 必须考虑可能i>max,游戏无法继续,要结束.

这题要重做
*/

public class Solution {
    public int jump(int[] A) {
        int step=0;
        int max=0;
        int lastlastlastmax=0;
        
        for(int i=0;i<A.length;i++){
            if(i>max) return -1;
            if(i>lastlastlastmax){
                lastlastlastmax=max;
                step++;
            }
            max=Math.max(max, i+A[i]);
        }
        return step;
        
    }
}
