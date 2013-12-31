/*
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

// use sort: O(nlgn)
// 神奇!: use bit manipulation:出现两次 xor=0;0与一个数xor保持不变
public class Solution {
    public int singleNumber(int[] A) {
       int number = 0;  
        for (int i = 0; i < A.length; i++) {  
            number = number^A[i];  
        }  
        return number;  
    }
}
