/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
*/

// 用变量remain记录剩余的油量,每到一个加油站remain+=gas[i]-cost[i], 如果remain持续>0, 表示可以走到下一站;
// 如果所有油量相加>=0, 一定有解

// 遍历所有油站即可.

// 优化: 如果从i走, 到j走不下去了, 那(i,j)中间的任何一个开始都走不下去. 因为remain始终是正的


//整个数组从头到尾跑一遍就好,i是要从0-end的,另外用index来记录起始点

//用while比for好很多,一定要自己用一个例子跑一遍,不然代码是不可能对的

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int remain=0;
        int index=0, i=0;
        int total=0;
        
        while(i<gas.length){
            remain+=gas[i]-cost[i];
            total+=gas[i]-cost[i];
            if(remain<0){
                remain=0;
                index=i+1;
            }
            i++;
        }
        return total>=0?index:-1;
    }
}
