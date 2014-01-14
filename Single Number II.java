/*
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

// 总共32位, 出现次数不为3的倍数的那一位一定为1, 其他位为0

// 注意getBit的用法num=num & (1<<i) 这里要移A[j]而不是1, 因为要当个位数相加
// 注意setBit的用法num=num|(1<<i)

public class Solution {
    public int singleNumber(int[] A) {
        int res=0;
        for(int i=0; i<32; i++){
            int temp=0;
            for(int j=0; j<A.length;j++){
                temp+=(A[j]>>i) & 1;
                
            }
            if(temp%3!=0) res=res|(1<<i);
        } 
        return res;
        
    }
}
