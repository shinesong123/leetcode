/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/

// keep一个max值,计算当前位置最远能跳到哪里; 如果i在max的范围内, 可以看i能不能让max的距离更大; 如果i不在max范围内,表示那一点走不到, 更别提更远的了
//如果整个数组跑完, max<length, 就false;

// 问题1: reach last index, 超过, 而不reach在那一点可以吗?--不存在这个问题, 因为可以一步一步跳,数组里的数字是上限,可以比它小任意的跳. 

public class Solution {
    public boolean canJump(int[] A) {
        int max=0;
        for(int i=0; i<A.length; i++){
            if(i<=max) max=Math.max(max, i+A[i]); 
        }
        if(max<A.length-1) return false;
        else return true;
        
    }
}
